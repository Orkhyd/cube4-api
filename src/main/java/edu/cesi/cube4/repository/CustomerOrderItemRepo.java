package edu.cesi.cube4.repository;

import edu.cesi.cube4.model.CustomerOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOrderItemRepo extends JpaRepository<CustomerOrderItem,Integer> {
}
