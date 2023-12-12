package edu.cesi.cube4.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Table(name = "fournisseurs")
@Entity
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom_entreprise", length = 100)
    private String nomEntreprise;

    @NotBlank
    @Column(name = "nom", length = 30)
    private String nom;

    @NotBlank
    @Column(name = "courriel", length = 100)
    private String courriel;


    @Column(name = "numero_telephone", length = 20)
    private String numeroTelephone;

    @CreationTimestamp
    @Column(name = "date_creation")
    private LocalDateTime dateCreation;

    @UpdateTimestamp
    @Column(name = "date_modification")
    private LocalDateTime dateModification;

    @Column(name = "supprime")
    private Boolean supprime;
}
