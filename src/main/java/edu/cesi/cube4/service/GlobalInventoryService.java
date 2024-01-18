package edu.cesi.cube4.service;

import edu.cesi.cube4.model.GlobalInventory;
import edu.cesi.cube4.repository.GlobalInventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class GlobalInventoryService {
    private final GlobalInventoryRepo globalInventoryRepo;

    @Autowired
    public GlobalInventoryService(GlobalInventoryRepo globalInventoryRepo) {
        this.globalInventoryRepo = globalInventoryRepo;
    }

    public ResponseEntity<List<GlobalInventory>> findAllGlobalInventories() {
        List<GlobalInventory> globalInventories = globalInventoryRepo.findAll();
        return new ResponseEntity<>(globalInventories, HttpStatus.OK);
    }

    public GlobalInventory saveGlobalInventory(GlobalInventory globalInventory) {
        return globalInventoryRepo.save(globalInventory);
    }

    public ResponseEntity<GlobalInventory> createGlobalInventory() {
        GlobalInventory globalInventory = saveGlobalInventory(new GlobalInventory());
        return new ResponseEntity<>(globalInventory, HttpStatus.CREATED);
    }

    public ResponseEntity<GlobalInventory> findGlobalInventoryById(Integer id) {
        Optional<GlobalInventory> optional = globalInventoryRepo.findById(id);
        return optional.map(globalInventory -> new ResponseEntity<>(globalInventory, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<GlobalInventory> updateGlobalInventory(Integer id, GlobalInventory globalInventory) {
        Optional<GlobalInventory> optional = globalInventoryRepo.findById(id);
        if (optional.isPresent()) {
            saveGlobalInventory(globalInventory);
            return new ResponseEntity<>(globalInventory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
