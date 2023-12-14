package edu.cesi.cube4.repository;

import edu.cesi.cube4.model.StockTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockTrackingRepo extends JpaRepository<StockTracking,Integer> {
    List<StockTracking> findByItem_Id(Integer itemId);
}
