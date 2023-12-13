package edu.cesi.cube4.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "categories")
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(length = 50)
    private String name;

    @CreationTimestamp
    @Column()
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column()
    private LocalDateTime modificationDate;

    @Column()
    private Boolean delete = false;


}
