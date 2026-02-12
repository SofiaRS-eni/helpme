package fr.eni.helpme.dal;

import fr.eni.helpme.bo.Reponse;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReponseRepository extends MongoRepository<Reponse,String> {

}
