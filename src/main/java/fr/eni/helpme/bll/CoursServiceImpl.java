package fr.eni.helpme.bll;

import fr.eni.helpme.bo.Cours;
import fr.eni.helpme.bo.Ticket;
import fr.eni.helpme.dal.CoursRepository;
import fr.eni.helpme.dto.CoursDTO;
import fr.eni.helpme.exception.EmailClientAlreadyExistException;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class CoursServiceImpl implements CoursService {

    @Autowired
    private CoursRepository coursRepository;
    @Override
    public Cours ajoutCours(CoursDTO coursDTO) {
        Cours cours = new Cours(coursDTO.getNom(),coursDTO.getFormateur());
        BeanUtils.copyProperties(coursDTO,cours);
        Cours newCours = null;
        try{
            newCours = coursRepository.save(cours);
        }catch (DataIntegrityViolationException ex)
        {
            throw new EmailClientAlreadyExistException();
        }
        return newCours;
    }

    @Override
    public List<Cours> getAllCours() {
        List<Cours> cours = coursRepository.findAll();
        return cours;
    }

}
