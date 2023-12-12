package edu.cesi.cube4.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "typetransaction")
public class TypeTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "description", length = 30)
    private String description;
}
