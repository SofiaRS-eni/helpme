package fr.eni.helpme.bo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
public class Ticket {
    @Id
    @EqualsAndHashCode.Exclude
    private String id;

    @NonNull
    private String auteur;

    @NonNull
    private String message;

    @EqualsAndHashCode.Exclude
    private LocalDateTime creation;

    private List<Reponse> reponses;

    private Etat etat;

    public Ticket(@NonNull String auteur, @NonNull String message) {
        this.auteur = auteur;
        this.message = message;
        this.creation = LocalDateTime.now();
        this.etat = Etat.OUVERT;
    }

}
