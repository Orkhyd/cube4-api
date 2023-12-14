package edu.cesi.cube4.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Item {

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
    private LocalDateTime updateDate;


    @Column()
    private Boolean isDeleted = false;

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
    private Boolean trending;

    @ManyToOne
    @JoinColumn(name = "id_supplier", referencedColumnName = "id")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "id_category", referencedColumnName = "id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "id_subcategory", referencedColumnName = "id")
    private SubCategory subCategory;

    @ManyToOne
    @JoinColumn(name = "id_house", referencedColumnName = "id")
    private House house;
}
