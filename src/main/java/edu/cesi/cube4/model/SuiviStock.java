package edu.cesi.cube4.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "suivistock")
public class SuiviStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_article", referencedColumnName = "id")
    private Article article;

    @Column(name = "quantite_avant_transaction")
    private Integer quantiteAvantTransaction;

    @Column(name = "quantite_transaction")
    private Integer quantiteTransaction;

    @Column(name = "quantite_apres_transaction")
    private Integer quantiteApresTransaction;

    @ManyToOne
    @JoinColumn(name = "id_type_transaction", referencedColumnName = "id")
    private TypeTransaction typeTransaction;

    @Column(name = "date_heure_transaction")
    private LocalDateTime dateHeureTransaction;

    @Lob
    @Column(name = "note")
    private String note;

}
