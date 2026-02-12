package fr.eni.helpme.bll;

import fr.eni.helpme.bo.Cours;
import fr.eni.helpme.dto.CoursDTO;

import java.util.List;

public interface CoursService {
    Cours ajoutCours(CoursDTO coursDTO);
    List<Cours> getAllCours();
}
