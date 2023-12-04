package edu.cesi.cube4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "articles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom", length = 50)
    private String nom;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "prix_vente", precision = 10, scale = 2)
    private BigDecimal prixVente;

    @Column(name = "prix_achat", precision = 10, scale = 2)
    private BigDecimal prixAchat;

    @Column(name = "id_fournisseur")
    private Integer idFournisseur;

    @Column(name = "date_creation")
    private LocalDateTime dateCreation;

    @Column(name = "date_modification")
    private LocalDateTime dateModification;

    @Column(name = "supprime")
    private Boolean supprime;

    @Column(name = "quantite_enregistree")
    private Integer quantiteEnregistree;

    @Column(name = "commande_auto")
    private Boolean commandeAuto;

    @Column(name = "seuil_stock_min")
    private Integer seuilStockMin;

    @Column(name = "prix_carton", precision = 5, scale = 2)
    private BigDecimal prixCarton;

    @Column(name = "annee_vin")
    private Integer anneeVin;

    @Column(name = "id_categorie")
    private Integer idCategorie;

    @Column(name = "id_souscategorie")
    private Integer idSouscategorie;

    @Column(name = "id_maison")
    private Integer idMaison;

    @Column(name = "tendance")
    private Boolean tendance;
}
