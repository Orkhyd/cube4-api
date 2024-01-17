package edu.cesi.cube4.service;

import edu.cesi.cube4.model.GlobalInventory;
import edu.cesi.cube4.model.InventoryItem;
import edu.cesi.cube4.repository.InventoryItemRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryItemService {

    private final InventoryItemRepo inventoryItemRepo;

    public InventoryItemService(InventoryItemRepo inventoryItemRepo) {
        this.inventoryItemRepo = inventoryItemRepo;
    }

    public Optional<List<InventoryItem>> findAllInventoryItemsByGlobalId(Integer globalId) {
        return inventoryItemRepo.findByGlobalInventoryId(globalId);
    }

    public List<InventoryItem>  findAllInventoryItems(){return inventoryItemRepo.findAll();}

    public InventoryItem saveInventoryItem(InventoryItem inventoryItem) {
        return inventoryItemRepo.save(inventoryItem);
    }
}
