package edu.cesi.cube4.controller;

import edu.cesi.cube4.model.GlobalInventory;
import edu.cesi.cube4.model.House;
import edu.cesi.cube4.service.GlobalInventoryService;
import edu.cesi.cube4.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/globalinventory")
public class GlobalInventoryController {

    private final GlobalInventoryService globalInventoryService;

    @Autowired
    GlobalInventoryController(GlobalInventoryService globalInventoryService) {
        this.globalInventoryService = globalInventoryService;
    }

    @GetMapping
    public ResponseEntity<List<GlobalInventory>> getAllGlobalInventories() {
        return globalInventoryService.findAllGlobalInventories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalInventory> getGlobalInventoryById(@PathVariable Integer id) {
        return globalInventoryService.findGlobalInventoryById(id);
    }

    @PostMapping
    public ResponseEntity<GlobalInventory> createGlobalInventory() {
        return globalInventoryService.createGlobalInventory();
    }

    @PutMapping("/{id}")
    public ResponseEntity<GlobalInventory> updateGlobalInventory(@PathVariable Integer id, @RequestBody GlobalInventory globalInventory) {
        return globalInventoryService.updateGlobalInventory(id, globalInventory);
    }

}
