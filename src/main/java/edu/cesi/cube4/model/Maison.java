package edu.cesi.cube4.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "houses")
public class Maison {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(length = 255)
    private String name;

    @CreationTimestamp
    @Column()
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column()
    private LocalDateTime modificationDate;

    @Column()
    private Boolean delete;
}
