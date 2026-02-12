package fr.eni.helpme.bll;

import fr.eni.helpme.bo.Cours;
import fr.eni.helpme.bo.Ticket;
import fr.eni.helpme.dal.CoursRepository;
import fr.eni.helpme.dto.CoursDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CoursServiceTest {

    @Autowired
    private CoursService coursService;

    @Autowired
    private CoursRepository coursRepository;

    @Test
    @DisplayName("Test ajout Cours")
    public void ajoutCours()
    {
        //Assert
        CoursDTO coursDTO = new CoursDTO("dev","bob");
        //Act
        Cours cours = coursService.ajoutCours(coursDTO);
        //Arrange
        Assertions.assertNotNull(cours.getId(), "L'id doit être généré");

        Cours cours1 = coursRepository.findById(cours.getId()).orElse(null);
        Assertions.assertNotNull(cours1, "Le ticket doit exister en base");
        Assertions.assertEquals(cours, cours1);
    }
}
