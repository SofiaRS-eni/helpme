package fr.eni.helpme.bll;

import fr.eni.helpme.bo.Reponse;
import fr.eni.helpme.bo.Ticket;
import fr.eni.helpme.dal.ReponseRepository;
import fr.eni.helpme.dal.TicketRepository;
import fr.eni.helpme.dto.ReponseDTO;
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
public class ReponseServiceImpl implements ReponseService{

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private ReponseRepository reponseRepository;

    @Override
    public Reponse ajoutReponse(String ticketId, ReponseDTO reponseDTO) {

        Ticket ticket=ticketRepository.findById(ticketId).orElseThrow(() -> new RuntimeException("Ticket introuvable"));

        Reponse reponse = new Reponse(reponseDTO.getAuteur(),reponseDTO.getMessage());

        if(ticket.getReponses()==null)
        {
            ticket.setReponses(new ArrayList<>());
        }
        ticket.getReponses().add(reponse);

        ticketRepository.save(ticket);
        return reponse;
    }

    @Override
    public List<Reponse> getAllReponses(String id) {
        Ticket ticket=ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket introuvable"));

        List<Reponse> reponses = ticket.getReponses();
        return reponses;
    }

}
