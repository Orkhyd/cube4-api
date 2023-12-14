package edu.cesi.cube4.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_global_inventory", referencedColumnName = "id")
    private GlobalInventory globalInventory;

    @ManyToOne
    @JoinColumn(name = "id_item", referencedColumnName = "id")
    private Item item;

    private Integer savedQuantity;

    private Integer realQuantity;

    @CreationTimestamp
    private LocalDateTime creationDate;

    @UpdateTimestamp
    private LocalDateTime updateDate;

}
