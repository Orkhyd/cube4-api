package edu.cesi.cube4.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "commandesclients")
public class CommandeClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_statut", referencedColumnName = "id")
    private Statut statut;

    @Column(name = "prix_total", precision = 10, scale = 2)
    private BigDecimal prixTotal;

    @CreationTimestamp
    @Column(name = "date_creation")
    private LocalDateTime dateCreation;

    @UpdateTimestamp
    @Column(name = "date_modification")
    private LocalDateTime dateModification;

}