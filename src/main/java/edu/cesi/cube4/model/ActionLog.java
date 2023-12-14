package edu.cesi.cube4.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class ActionLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_admin", referencedColumnName = "id")
    private Admin admin;

    @Column(length = 50)
    private String actionType;

    @Column(length = 50)
    private String relatedTable;

    @Lob
    private String description;

    private LocalDateTime actionDate;
}