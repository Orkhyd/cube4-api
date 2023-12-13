package edu.cesi.cube4.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "utilisateursadmin")
@Data
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(name = "nom_utilisateur", length = 50)
    private String nomUtilisateur;

    @NotBlank
    @Column(name = "mot_de_passe", length = 512)
    private String motDePasse;

    @CreationTimestamp
    @Column(name = "date_creation")
    private LocalDateTime dateCreation;

    @UpdateTimestamp
    @Column(name = "date_modification")
    private LocalDateTime dateModification;

    @Column(name = "date_suppression")
    private LocalDateTime dateSuppression;

    @Column(name = "supprime")
    private Boolean supprime;
}
