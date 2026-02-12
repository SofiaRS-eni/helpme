package fr.eni.helpme.bll;

import fr.eni.helpme.bo.Reponse;
import fr.eni.helpme.dto.ReponseDTO;

import java.util.List;

public interface ReponseService {

    Reponse ajoutReponse(String ticketId, ReponseDTO reponseDTO);
    List<Reponse> getAllReponses(String id);
}
