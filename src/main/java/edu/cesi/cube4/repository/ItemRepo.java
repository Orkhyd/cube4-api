package edu.cesi.cube4.repository;

import edu.cesi.cube4.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepo extends JpaRepository<Item,Integer> {
    Optional<List<Item>> findBySupplierId(Integer supplierId);
}
