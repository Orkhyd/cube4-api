package edu.cesi.cube4.repository;

import edu.cesi.cube4.model.GlobalInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GlobalInventoryRepo extends JpaRepository<GlobalInventory,Integer> {
}
