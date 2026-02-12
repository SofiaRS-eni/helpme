package fr.eni.helpme.bll;

import fr.eni.helpme.bo.Reponse;
import fr.eni.helpme.bo.Ticket;
import fr.eni.helpme.dal.TicketRepository;
import fr.eni.helpme.dto.ReponseDTO;
import fr.eni.helpme.dto.TicketDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TicketServiceTest {

    @Autowired
    private TicketService ticketService;

    @Autowired ReponseService reponseService;

    @Autowired
    private TicketRepository ticketRepository;

    @BeforeEach
    void setUp() {
        ticketRepository.deleteAll();
    }

    @Test
    @DisplayName("Test ajout ticket")
    public void testAjoutTicket() {

        // Arrange
        TicketDTO ticketDTO = new TicketDTO("test1", "this is fine *tout brûle*");

        // Act
        Ticket ticket = ticketService.ajoutTicket(ticketDTO);

        // Assert
        Assertions.assertNotNull(ticket.getId(), "L'id doit être généré");

        Ticket ticketBD = ticketRepository.findById(ticket.getId()).orElse(null);
        Assertions.assertNotNull(ticketBD, "Le ticket doit exister en base");
        Assertions.assertEquals(ticket, ticketBD);
    }

    @Test
    @DisplayName("Test ajout reponse a un ticket")
    public void testAjoutReponseTicket() {
        // Arrange
        TicketDTO ticketDTO = new TicketDTO("test1", "this is fine *tout brûle*");
        ReponseDTO reponseDTO= new ReponseDTO("test","testteeee");

        // Act
        Ticket ticket = ticketService.ajoutTicket(ticketDTO);
        Reponse reponse = reponseService.ajoutReponse(ticket.getId(),reponseDTO);

        //Assert
        Ticket ticketBD = ticketRepository.findById(ticket.getId()).orElse(null);
    }
}
