package edu.cesi.cube4.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class CustomerOrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_customer_order", referencedColumnName = "id")
    private CustomerOrder customerOrder;

    @ManyToOne
    @JoinColumn(name = "id_item", referencedColumnName = "id")
    private Item item;

    private Integer quantity;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    @CreationTimestamp
    private LocalDateTime creationDate;

    @UpdateTimestamp
    private LocalDateTime updateDate;
}
