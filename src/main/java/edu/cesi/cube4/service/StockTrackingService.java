package edu.cesi.cube4.service;

import edu.cesi.cube4.model.StockTracking;
import edu.cesi.cube4.repository.StockTrackingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockTrackingService {
    private final StockTrackingRepo stockTrackingRepo;

    @Autowired
    public StockTrackingService(StockTrackingRepo stockTrackingRepo) {
        this.stockTrackingRepo = stockTrackingRepo;
    }

    public List<StockTracking> findAllStockTracking() {
        return stockTrackingRepo.findAll();
    }

    public List<StockTracking> findStockTrackingByItemId(Integer itemId) {
        return stockTrackingRepo.findByItem_Id(itemId);
    }    

    public  StockTracking saveStockTracking(StockTracking stockTracking) {
        return stockTrackingRepo.save(stockTracking);
    }

}
