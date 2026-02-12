package fr.eni.helpme.rest;

import fr.eni.helpme.bll.ReponseService;
import fr.eni.helpme.bll.TicketService;
import fr.eni.helpme.bo.Reponse;
import fr.eni.helpme.bo.Ticket;
import fr.eni.helpme.dto.ReponseDTO;
import fr.eni.helpme.dto.TicketDTO;
import jakarta.validation.Valid;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketRestController {
    private final TicketService ticketService;
    private final ReponseService reponseService;

    public TicketRestController(TicketService ticketService, ReponseService reponseService) {
        this.ticketService = ticketService;
        this.reponseService = reponseService;
    }

    //Liste des tickets
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Ticket> getAllTickets()
    {
        List tickets = ticketService.getAllTickets();
        return tickets;
    }

    //Ajout des tickets
    /*@PostMapping("/{id}/ticket")
    public ResponseEntity<Ticket> ajoutTicket(@PathVariable String id, @Valid @RequestBody TicketDTO ticketDTO, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        Ticket ajoutTicket = ticketService.ajoutTicket(id,ticketDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ajoutTicket);
    }*/


    //Update d'un ticket en ajoutant des reponses
    @PatchMapping("/{id}/reponses")
    public ResponseEntity<Reponse> ajoutReponse(@PathVariable String id, @Valid @RequestBody ReponseDTO reponseDTO)
    {
        Reponse reponse = reponseService.ajoutReponse(id,reponseDTO);
        return ResponseEntity.ok(reponse);
    }

    //List des reponses par rapport a un ticket
    @GetMapping("/{id}/reponses")
    public ResponseEntity<List<Reponse>> getReponses(@PathVariable String id)
    {
        List<Reponse> reponses = reponseService.getAllReponses(id);
        return ResponseEntity.ok(reponses);
    }
}
