package fr.eni.helpme.rest;

import fr.eni.helpme.bll.CoursService;
import fr.eni.helpme.bll.TicketService;
import fr.eni.helpme.bo.Cours;
import fr.eni.helpme.bo.Ticket;
import fr.eni.helpme.dto.TicketDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cours")
public class CoursRestController {
    private final CoursService coursService;

    private final TicketService ticketService;


    public CoursRestController(CoursService coursService, TicketService ticketService) {
        this.coursService = coursService;
        this.ticketService = ticketService;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Cours> getAllCours()
    {
        List<Cours> cours = coursService.getAllCours();
        return cours;
    }

    @PostMapping("/{id}/ticket")
    public ResponseEntity<Ticket> ajoutTicket(@PathVariable String id, @Valid @RequestBody TicketDTO ticketDTO, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        Ticket ajoutTicket = ticketService.ajoutTicket(id,ticketDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ajoutTicket);
    }
}
