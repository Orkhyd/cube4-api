package edu.cesi.cube4.service;

import edu.cesi.cube4.model.SuiviStock;
import edu.cesi.cube4.repository.SuiviStockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuiviStockService {
    private final SuiviStockRepo suiviStockRepo;

    @Autowired
    public SuiviStockService(SuiviStockRepo suiviStockRepo) {
        this.suiviStockRepo = suiviStockRepo;
    }

    public List<SuiviStock> findAllStockTracking() {
        return suiviStockRepo.findAll();
    }

    public List<SuiviStock> findStockTrackingByItemId(Integer itemId) {
        return suiviStockRepo.findByItem_Id(itemId);
    }    

    public  SuiviStock saveStockTracking(SuiviStock SuiviStock) {
        return suiviStockRepo.save(SuiviStock);
    }

}
