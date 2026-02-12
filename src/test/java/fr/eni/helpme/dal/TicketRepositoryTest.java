package fr.eni.helpme.dal;

import fr.eni.helpme.bo.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TicketRepositoryTest {

    @Autowired
    private TicketRepository ticketRepository;

    @BeforeEach
    void setUp() {
        ticketRepository.deleteAll();
    }

    @Test
    @DisplayName("test creation ticket")
    void testCreationTicket()
    {
        //Arrange
        Ticket ticket = new Ticket("test","thid is fine *tout brule*");

        //Act
        ticketRepository.save(ticket);

        //Assert

        Assertions.assertNotNull(ticket.getId());
        Ticket ticketDB = ticketRepository.findById(ticket.getId()).orElse(null);
        Assertions.assertNotNull(ticketDB);
        Assertions.assertEquals(ticket, ticketDB);
    }
}
