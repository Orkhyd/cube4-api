package edu.cesi.cube4.controller;

import edu.cesi.cube4.model.StockTracking;
import edu.cesi.cube4.service.StockTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocktracking")
public class StockTrackingController {

    private final StockTrackingService stockTrackingService;

    @Autowired
    StockTrackingController(StockTrackingService stockTrackingService) {
        this.stockTrackingService = stockTrackingService;
    }

    @GetMapping
    public List<StockTracking> getAllStockTracking() {
        return stockTrackingService.findAllStockTracking();
    }

    @PostMapping
    public ResponseEntity<StockTracking> createStockTracking(@RequestBody StockTracking stockTracking) {
        StockTracking savedStockTracking = stockTrackingService.saveStockTracking(stockTracking);
        return new ResponseEntity<>(savedStockTracking, HttpStatus.CREATED);
    }

    @GetMapping("/item/{itemId}")
    public ResponseEntity<List<StockTracking>> getStockTrackingByItemId(@PathVariable Integer itemId) {
        List<StockTracking> stockTrackings = stockTrackingService.findStockTrackingByItemId(itemId);
        if (stockTrackings.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(stockTrackings, HttpStatus.OK);
    }

}
