package edu.cesi.cube4.repository;

import edu.cesi.cube4.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryItemRepo extends JpaRepository<InventoryItem,Integer> {
    Optional<List<InventoryItem>> findByGlobalInventoryId(Integer globalInventoryId);
}
