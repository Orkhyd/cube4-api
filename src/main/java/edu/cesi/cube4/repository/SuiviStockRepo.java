package edu.cesi.cube4.repository;

import edu.cesi.cube4.model.Admin;
import edu.cesi.cube4.model.SuiviStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SuiviStockRepo extends JpaRepository<SuiviStock, Integer> {
    List<SuiviStock> findByItem_Id(Integer itemId);
}
