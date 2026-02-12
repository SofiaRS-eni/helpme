package fr.eni.helpme.bll;

import fr.eni.helpme.bo.Ticket;
import fr.eni.helpme.dto.TicketDTO;

import java.util.List;

public interface TicketService {
    Ticket ajoutTicket(String coursid,TicketDTO ticketDTO);
    List<Ticket> getAllTickets();
}
