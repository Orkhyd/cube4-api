package edu.cesi.cube4.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "logsactions")
public class LogAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur_admin", referencedColumnName = "id")
    private Admin admin;

    @Column(name = "type_action", length = 50)
    private String typeAction;

    @Column(name = "table_affectee", length = 50)
    private String tableAffectee;

    @Column(name = "id_ligne_affectee")
    private Integer idLigneAffectee;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "date_heure_action")
    private LocalDateTime dateHeureAction;
}