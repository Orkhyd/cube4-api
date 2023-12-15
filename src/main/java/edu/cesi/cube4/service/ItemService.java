package edu.cesi.cube4.service;

import edu.cesi.cube4.model.Item;
import edu.cesi.cube4.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private final ItemRepo itemRepo;

    @Autowired
    public ItemService(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    public List<Item> findAllItems() {
        return itemRepo.findAll();
    }

    public Item saveItem(Item item) {
        return itemRepo.save(item);
    }

    public ResponseEntity<?> findItemById(Integer id) {
        Optional<Item> item = itemRepo.findById(id);
        if (item.isEmpty()) {
            return new ResponseEntity<>("No item was found for id: "+id, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(item, HttpStatus.OK);
        }
    }
}
