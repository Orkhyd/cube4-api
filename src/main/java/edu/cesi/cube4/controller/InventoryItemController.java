package edu.cesi.cube4.controller;

import edu.cesi.cube4.model.GlobalInventory;
import edu.cesi.cube4.model.InventoryItem;
import edu.cesi.cube4.model.Item;
import edu.cesi.cube4.model.StockTracking;
import edu.cesi.cube4.service.GlobalInventoryService;
import edu.cesi.cube4.service.InventoryItemService;
import edu.cesi.cube4.service.ItemService;
import edu.cesi.cube4.service.StockTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/inventoryitem")
public class InventoryItemController {

    private final InventoryItemService inventoryItemService;
    private final GlobalInventoryService globalInventoryService;
    private final ItemService itemService;
    private final StockTrackingService stockTrackingService;

    @Autowired
    InventoryItemController(InventoryItemService inventoryItemService, GlobalInventoryService globalInventoryService, ItemService itemService, StockTrackingService stockTrackingService) {
        this.inventoryItemService = inventoryItemService;
        this.globalInventoryService = globalInventoryService;
        this.itemService = itemService;
        this.stockTrackingService = stockTrackingService;
    }

    @GetMapping
    public List<InventoryItem> getAllInventoryItems() {
        return inventoryItemService.findAllInventoryItems();
    }

    @GetMapping("/{globalInventoryId}")
    public ResponseEntity<List<InventoryItem>> getAllInventoryItemsByGlobalId(@PathVariable Integer globalInventoryId) {

        Optional<List<InventoryItem>> optional =  inventoryItemService.findAllInventoryItemsByGlobalId(globalInventoryId);
        return optional.map(inventoryItems -> new ResponseEntity<>(inventoryItems, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Object> createInventoryItem(@RequestBody InventoryItem inventoryItem) {

        // Save InventoryItem
        InventoryItem savedInventoryItem = inventoryItemService.saveInventoryItem(inventoryItem);

        Item item = savedInventoryItem.getItem();
        Integer savedQuantity = item.getSaveQuantity();
        Integer realQuantity = inventoryItem.getRealQuantity();
        Integer delta = realQuantity - savedQuantity;
        GlobalInventory globalInventory = savedInventoryItem.getGlobalInventory();

        // Set savedItemCount
        savedInventoryItem.setSavedQuantity(savedQuantity);

        // Update globalInventory item totals
        globalInventory.setTotalRealItems(globalInventory.getTotalRealItems() + realQuantity);
        globalInventory.setTotalSavedItems(globalInventory.getTotalSavedItems() + savedQuantity);
        globalInventoryService.saveGlobalInventory(globalInventory);

        // Save real quantity as new saved quantity for item
        item.setSaveQuantity(realQuantity);
        itemService.saveItem(item);
        StockTracking stockTracking = new StockTracking();
        stockTracking.setItem(item);
        stockTracking.setQuantityBeforeTransaction(savedQuantity);
        stockTracking.setQuantityAfterTransaction(realQuantity);
        stockTracking.setTransactionQuantity(delta);
        stockTrackingService.adjustStockTracking(stockTracking);

        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("inventoryItem", savedInventoryItem);
        responseBody.put("delta", delta);
        return new ResponseEntity<>(responseBody, HttpStatus.CREATED);
    }
}
