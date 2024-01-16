package edu.cesi.cube4.service;

import edu.cesi.cube4.model.Item;
import edu.cesi.cube4.model.StockTracking;
import edu.cesi.cube4.model.TransactionType;
import edu.cesi.cube4.repository.StockTrackingRepo;
import edu.cesi.cube4.repository.TransactionTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockTrackingService {
    private final StockTrackingRepo stockTrackingRepo;
    private final TransactionTypeRepo transactionTypeRepo;

    @Autowired
    public StockTrackingService(StockTrackingRepo stockTrackingRepo, TransactionTypeRepo transactionTypeRepo) {
        this.stockTrackingRepo = stockTrackingRepo;
        this.transactionTypeRepo = transactionTypeRepo;
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

    public void createNewStockTracking(Item item) {
        StockTracking stockTracking = new StockTracking();
        stockTracking.setItem(item);
        TransactionType defaultTransactionType = transactionTypeRepo.findById(5)
                .orElseThrow(() -> new RuntimeException("Default transaction type not found"));
        stockTracking.setTransactionType(defaultTransactionType);
        stockTrackingRepo.save(stockTracking);
    }

    public void adjustStockTracking(StockTracking stockTracking) {
        TransactionType defaultTransactionType = transactionTypeRepo.findById(4)
                .orElseThrow(() -> new RuntimeException("Default transaction type not found"));
        stockTracking.setTransactionType(defaultTransactionType);
        stockTrackingRepo.save(stockTracking);
    }

    public void supplierOrderStockTracking(StockTracking stockTracking) {
        TransactionType defaultTransactionType = transactionTypeRepo.findById(1)
                .orElseThrow(() -> new RuntimeException("Default transaction type not found"));
        stockTracking.setTransactionType(defaultTransactionType);
        stockTrackingRepo.save(stockTracking);
    }

}
