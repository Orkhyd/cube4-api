package edu.cesi.cube4.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "articles")
@Data
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(name = "nom", length = 50)
    private String nom;

    @NotBlank
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Min(0)
    @NotNull
    @Column(name = "prix_vente", precision = 10, scale = 2)
    private BigDecimal prixVente;

    @Min(0)
    @NotNull
    @Column(name = "prix_achat", precision = 10, scale = 2)
    private BigDecimal prixAchat;

    @CreationTimestamp
    @Column(name = "date_creation", updatable = false)
    private LocalDateTime dateCreation;

    @UpdateTimestamp
    @Column(name = "date_modification")
    private LocalDateTime dateModification;


    @Column(name = "supprime")
    private Boolean supprime = false;

    @Min(0)
    @Column(name = "quantite_enregistree")
    private Integer quantiteEnregistree;

    @Column(name = "commande_auto")
    private Boolean commandeAuto;

    @Column(name = "seuil_stock_min")
    private Integer seuilStockMin;

    @Column(name = "prix_carton", precision = 7, scale = 2)
    private BigDecimal prixCarton;

    @NotNull
    @Column(name = "annee_vin")
    private Integer anneeVin;

    @Column(name = "tendance")
    private Boolean tendance;

    @ManyToOne
    @JoinColumn(name = "id_fournisseur", referencedColumnName = "id")
    private Fournisseur fournisseur;

    @ManyToOne
    @JoinColumn(name = "id_categorie", referencedColumnName = "id")
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name = "id_souscategorie", referencedColumnName = "id")
    private SousCategorie sousCategorie;

    @ManyToOne
    @JoinColumn(name = "id_maison", referencedColumnName = "id")
    private Maison maison;
}
