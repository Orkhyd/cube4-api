package edu.cesi.cube4.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "articlescommandes")
public class ArticleCommande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_commande", referencedColumnName = "id")
    private CommandeClient commandeClient;

    @ManyToOne
    @JoinColumn(name = "id_article", referencedColumnName = "id")
    private Article article;

    @Column(name = "quantite")
    private Integer quantite;

    @Column(name = "prix_au_moment_de_la_commande", precision = 10, scale = 2)
    private BigDecimal prixAuMomentDeLaCommande;

    @CreationTimestamp
    @Column(name = "date_creation")
    private LocalDateTime dateCreation;

    @UpdateTimestamp
    @Column(name = "date_modification")
    private LocalDateTime dateModification;
}
