package edu.cesi.cube4.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "commandesfournisseurs")
public class CommandeFournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_fournisseur", referencedColumnName = "id")
    private Fournisseur fournisseur;

    @ManyToOne
    @JoinColumn(name = "id_article", referencedColumnName = "id")
    private Article article;

    @Column(name = "quantite")
    private Integer quantite;

    @Column(name = "prix_achat", precision = 10, scale = 2)
    private BigDecimal prixAchat;

    @ManyToOne
    @JoinColumn(name = "id_statut", referencedColumnName = "id")
    private Statut statut;

    @CreationTimestamp
    @Column(name = "date_creation")
    private LocalDateTime dateCreation;

    @UpdateTimestamp
    @Column(name = "date_modification")
    private LocalDateTime dateModification;
}
