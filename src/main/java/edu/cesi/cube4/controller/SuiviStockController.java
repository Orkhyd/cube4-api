package edu.cesi.cube4.controller;

import edu.cesi.cube4.model.Categorie;
import edu.cesi.cube4.model.SuiviStock;
import edu.cesi.cube4.service.SuiviStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocktracking")
public class SuiviStockController {

    private final SuiviStockService suiviStockService;

    @Autowired
    SuiviStockController(SuiviStockService suiviStockService) {
        this.suiviStockService = suiviStockService;
    }

    @GetMapping
    public List<SuiviStock> getAllStockTracking() {
        return suiviStockService.findAllStockTracking();
    }

    @PostMapping
    public ResponseEntity<SuiviStock> createStockTracking(@RequestBody SuiviStock suiviStock) {
        SuiviStock savedStockTracking = suiviStockService.saveStockTracking(suiviStock);
        return new ResponseEntity<>(savedStockTracking, HttpStatus.CREATED);
    }

    @GetMapping("/item/{itemId}")
    public ResponseEntity<List<SuiviStock>> getStockTrackingByItemId(@PathVariable Integer itemId) {
        List<SuiviStock> stockTrackings = suiviStockService.findStockTrackingByItemId(itemId);
        if (stockTrackings.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(stockTrackings, HttpStatus.OK);
    }

}
