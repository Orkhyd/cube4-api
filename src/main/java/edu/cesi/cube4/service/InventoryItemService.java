package edu.cesi.cube4.service;

import edu.cesi.cube4.model.GlobalInventory;
import edu.cesi.cube4.repository.GlobalInventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryItemService {

    private final GlobalInventoryRepo globalInventoryRepo;

    @Autowired
    public InventoryItemService(GlobalInventoryRepo globalInventoryRepo) {
        this.globalInventoryRepo = globalInventoryRepo;
    }

    public GlobalInventory saveGlobalInventory(GlobalInventory globalInventory) {
        return globalInventoryRepo.save(globalInventory);
    }

    public List<GlobalInventory> findAllGlobalInventories() {
        return globalInventoryRepo.findAll();
    }

    public Optional<GlobalInventory> findGlobalInventoryById(Integer id) {
        return globalInventoryRepo.findById(id);
    }

}
