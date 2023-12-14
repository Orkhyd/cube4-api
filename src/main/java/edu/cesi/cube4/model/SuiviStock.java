package edu.cesi.cube4.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "stocktracking")
public class SuiviStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_item", referencedColumnName = "id")
    private Article item;

    @Column()
    private Integer quantityBeforeTransaction;

    @Column()
    private Integer quantityTransaction;

    @Column()
    private Integer quantityAfterTransaction;

    @ManyToOne
    @JoinColumn(name = "id_type_transaction", referencedColumnName = "id")
    private TypeTransaction idTypeTransaction;

    @Column()
    private LocalDateTime dateTransaction;

    @Lob
    @Column()
    private String note;

}
