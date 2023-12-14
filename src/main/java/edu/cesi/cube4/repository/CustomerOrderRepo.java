package edu.cesi.cube4.repository;

import edu.cesi.cube4.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOrderRepo extends JpaRepository<CustomerOrder,Integer> {
}
