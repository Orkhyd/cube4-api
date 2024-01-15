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

    public Optional<Item> findItemById(Integer id) {
        return itemRepo.findById(id);
    }
}
