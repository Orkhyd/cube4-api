package edu.cesi.cube4.controller;

import edu.cesi.cube4.model.Item;
import edu.cesi.cube4.service.ItemService;
import edu.cesi.cube4.service.StockTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;
    private final StockTrackingService stockTrackingService;

    @Autowired
    public ItemController(ItemService itemService, StockTrackingService stockTrackingService) {
        this.itemService = itemService;
        this.stockTrackingService = stockTrackingService;
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        return new ResponseEntity<>(itemService.findAllItems(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item savedItem = itemService.saveItem(item);
        stockTrackingService.createNewStockTracking(item);

        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Optional<Item> getItemById(@PathVariable Integer id) {
        return itemService.findItemById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Item> deleteItem(@PathVariable Integer id) {
        Optional<Item> optional = itemService.findItemById(id);
        if (optional.isPresent()) {
            itemService.deleteItem(optional.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }       
    }


    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Integer id, @RequestBody Item itemDetails) {
        // First, try to find the item by ID using the itemService
        Optional<Item> optional = itemService.findItemById(id);

        // Check if the item exists (response status is 200 OK and body is an instance of Item)
        if (optional.isPresent()) {
//            Item itemToUpdate = optional.get();
            itemService.saveItem(itemDetails);
            return new ResponseEntity<>(itemDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);


        }


    }
}
