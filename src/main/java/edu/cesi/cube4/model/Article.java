package edu.cesi.cube4.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "items")
@Data
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(length = 50)
    private String name;

    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String description;

    @Min(0)
    @NotNull
    @Column(precision = 10, scale = 2)
    private BigDecimal sellPrice;

    @Min(0)
    @NotNull
    @Column(precision = 10, scale = 2)
    private BigDecimal buyPrice;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column()
    private LocalDateTime modificationDate;


    @Column()
    private Boolean delete = false;

    @Min(0)
    @Column()
    private Integer saveQuantity;

    @Column()
    private Boolean autoOrder;

    @Column()
    private Integer minOrderThreshold;

    @Column(precision = 7, scale = 2)
    private BigDecimal cartonPrice;

    @NotNull
    @Column()
    private Integer wineYear;

    @Column()
    private Boolean tendance;

    @ManyToOne
    @JoinColumn(name = "id_supplier", referencedColumnName = "id")
    private Fournisseur supplier;

    @ManyToOne
    @JoinColumn(name = "id_categorie", referencedColumnName = "id")
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name = "id_subcategorie", referencedColumnName = "id")
    private SousCategorie subCategorie;

    @ManyToOne
    @JoinColumn(name = "id_house", referencedColumnName = "id")
    private Maison house;
}
