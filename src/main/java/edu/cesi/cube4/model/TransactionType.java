package edu.cesi.cube4.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class TransactionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 30)
    private String description;
}
