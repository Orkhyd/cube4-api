package edu.cesi.cube4.repository;

import edu.cesi.cube4.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeTransactionRepo extends JpaRepository<TransactionType,Integer> {
}
