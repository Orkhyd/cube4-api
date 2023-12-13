package edu.cesi.cube4.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Table(name = "suppliers")
@Entity
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String nameEntreprise;

    @NotBlank
    @Column(length = 30)
    private String name;

    @NotBlank
    @Column(length = 100)
    private String mail;


    @Column(length = 20)
    private String phone;

    @CreationTimestamp
    @Column()
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column()
    private LocalDateTime modificationDate;

    @Column()
    private Boolean delete;
}
