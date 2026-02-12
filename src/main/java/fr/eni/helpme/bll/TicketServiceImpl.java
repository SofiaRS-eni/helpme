package fr.eni.helpme.bll;

import fr.eni.helpme.bo.Cours;
import fr.eni.helpme.bo.Ticket;
import fr.eni.helpme.dal.CoursRepository;
import fr.eni.helpme.dal.TicketRepository;
import fr.eni.helpme.dto.TicketDTO;
import fr.eni.helpme.exception.EmailClientAlreadyExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private CoursRepository coursRepository;

    @Override
    public Ticket ajoutTicket(String coursid,TicketDTO ticketDTO) {
        /*Ticket ticket = new Ticket(ticketDTO.getAuteur(),ticketDTO.getMessage());
        BeanUtils.copyProperties(ticketDTO,ticket);
        Ticket newTicket = null;
        try{
            newTicket = ticketRepository.save(ticket);
        }catch (DataIntegrityViolationException ex)
        {
            throw new EmailClientAlreadyExistException();
        }
        return newTicket;*/
        Cours cours = coursRepository.findById(coursid) .orElseThrow(() -> new RuntimeException("Cours introuvable"));
        Ticket ticket = new Ticket(ticketDTO.getAuteur(), ticketDTO.getMessage());
        ticket.setCours(cours);
        return ticketRepository.save(ticket);

    }

    @Override
    public List<Ticket> getAllTickets() {
        List<Ticket> ticket = ticketRepository.findAll();
        return ticket;
    }
}
