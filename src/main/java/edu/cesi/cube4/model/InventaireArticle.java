package edu.cesi.cube4.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "inventairesarticles")
public class InventaireArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_inventaire_global", referencedColumnName = "id")
    private InventaireGlobal inventaireGlobal;

    @ManyToOne
    @JoinColumn(name = "id_article", referencedColumnName = "id")
    private Article article;

    @Column(name = "quantite_enregistres")
    private Integer quantiteEnregistres;

    @Column(name = "quantite_reelle")
    private Integer quantiteReelle;

    @CreationTimestamp
    @Column(name = "date_creation")
    private LocalDateTime dateCreation;

    @UpdateTimestamp
    @Column(name = "date_modification")
    private LocalDateTime dateModification;

}
