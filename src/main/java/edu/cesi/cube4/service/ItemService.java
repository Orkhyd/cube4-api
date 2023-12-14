package edu.cesi.cube4.service;

import edu.cesi.cube4.model.Item;
import edu.cesi.cube4.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
