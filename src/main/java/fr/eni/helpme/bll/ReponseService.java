package fr.eni.helpme.bll;

import fr.eni.helpme.bo.Reponse;
import fr.eni.helpme.dto.ReponseDTO;

public interface ReponseService {

    public Reponse ajoutReponse(String ticketId, ReponseDTO reponseDTO);
}
