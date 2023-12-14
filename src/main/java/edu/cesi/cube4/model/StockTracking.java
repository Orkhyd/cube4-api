package edu.cesi.cube4.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class StockTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_item", referencedColumnName = "id")
    private Item item;

    private Integer quantityBeforeTransaction;

    private Integer transactionQuantity;

    private Integer quantityAfterTransaction;

    @ManyToOne
    @JoinColumn(name = "id_transaction_type", referencedColumnName = "id")
    private TransactionType transactionType;

    private LocalDateTime transactionDate;

    @Lob
    private String note;

}
