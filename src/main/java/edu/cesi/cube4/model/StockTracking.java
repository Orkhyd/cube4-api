package edu.cesi.cube4.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

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

    private Integer quantityBeforeTransaction = 0;

    private Integer transactionQuantity = 0;

    private Integer quantityAfterTransaction = 0;

    @ManyToOne
    @JoinColumn(name = "id_transaction_type", referencedColumnName = "id")
    private TransactionType transactionType;

    @CreationTimestamp
    private LocalDateTime transactionDate;

    @Lob
    private String note;

}
