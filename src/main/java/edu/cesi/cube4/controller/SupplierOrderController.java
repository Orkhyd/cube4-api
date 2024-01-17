package edu.cesi.cube4.controller;

import edu.cesi.cube4.model.Item;
import edu.cesi.cube4.model.Status;
import edu.cesi.cube4.model.StockTracking;
import edu.cesi.cube4.model.SupplierOrder;
import edu.cesi.cube4.repository.StatusRepo;
import edu.cesi.cube4.service.ItemService;
import edu.cesi.cube4.service.StockTrackingService;
import edu.cesi.cube4.service.SupplierOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/supplierorder")
public class SupplierOrderController {

    private final SupplierOrderService supplierOrderService;
    private final ItemService itemService;
    private final StatusRepo statusRepo;
    private final StockTrackingService stockTrackingService;

    public SupplierOrderController(SupplierOrderService supplierOrderService, ItemService itemService, StatusRepo statusRepo, StockTrackingService stockTrackingService) {
        this.supplierOrderService = supplierOrderService;
        this.itemService = itemService;
        this.statusRepo = statusRepo;
        this.stockTrackingService = stockTrackingService;
    }

    @PostMapping
    public ResponseEntity<SupplierOrder> createSupplierOrder(@RequestBody SupplierOrder supplierOrder) {
        Status status = statusRepo.findById(3).orElseThrow(() -> new RuntimeException("Default status not found"));
        supplierOrder.setStatus(status);
        SupplierOrder savedSupplierOrder = supplierOrderService.saveSupplierOrder(supplierOrder);

        // For now, add directly items to stock on command
        Item item = savedSupplierOrder.getItem();
        Integer formerQuantity = item.getSaveQuantity();
        Integer newQuantity = formerQuantity + savedSupplierOrder.getQuantity();
        item.setSaveQuantity(newQuantity);
        itemService.saveItem(item);

        StockTracking stockTracking = new StockTracking();
        stockTracking.setItem(item);
        stockTracking.setTransactionQuantity(savedSupplierOrder.getQuantity());
        stockTracking.setQuantityBeforeTransaction(formerQuantity);
        stockTracking.setQuantityAfterTransaction(newQuantity);
        stockTrackingService.supplierOrderStockTracking(stockTracking);

        return new ResponseEntity<>(savedSupplierOrder, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Optional<SupplierOrder> getSupplierOrderById(@PathVariable Integer id) {
        return supplierOrderService.findSupplierOrderById(id);
    }

    @GetMapping
    public List<SupplierOrder> getAllSupplierOrders(){return supplierOrderService.findAllSupplierOrders();}

}
