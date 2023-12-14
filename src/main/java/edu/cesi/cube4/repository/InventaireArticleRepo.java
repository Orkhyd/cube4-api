package edu.cesi.cube4.repository;

import edu.cesi.cube4.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventaireArticleRepo extends JpaRepository<InventoryItem,Integer> {
}
