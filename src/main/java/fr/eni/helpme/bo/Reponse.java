package fr.eni.helpme.bo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Reponse {
    @Id
    @EqualsAndHashCode.Exclude
    private String id;

    @NonNull
    private String auteur;

    @NonNull
    private String message;

    @EqualsAndHashCode.Exclude
    private LocalDateTime creation;

    public Reponse(@NonNull String auteur, @NonNull String message) {
        this.auteur = auteur;
        this.message = message;
        this.creation =LocalDateTime.now();
    }
}
