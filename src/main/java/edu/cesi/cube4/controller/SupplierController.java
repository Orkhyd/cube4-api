package edu.cesi.cube4.controller;

import edu.cesi.cube4.model.Item;
import edu.cesi.cube4.model.Supplier;
import edu.cesi.cube4.service.ItemService;
import edu.cesi.cube4.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    private final SupplierService supplierService;
    private final ItemService itemService;

    @Autowired
    SupplierController(SupplierService supplierService, ItemService itemService) {
        this.supplierService = supplierService;
        this.itemService = itemService;
    }

    @GetMapping
    public List<Supplier> getAllSuppliers() {
        return supplierService.findAllSuppliers();
    }

    @PostMapping
    public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier) {
        Supplier savedSupplier = supplierService.saveSupplier(supplier);
        return new ResponseEntity<>(savedSupplier, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Supplier> deleteSupplier(@PathVariable("id") Integer supplier) {
        Optional<Supplier> optional = supplierService.findSupplierById(supplier);
        if (optional.isPresent()) {
            supplierService.deleteSupplier(optional.get());

            // Remove auto order for items with deleted supplier
            Optional<List<Item>> optionalItems = itemService.findAllItemsBySupplierId(supplier);
            if (optionalItems.isPresent()){
                List<Item> itemList = optionalItems.get();
                for (Item item :
                        itemList) {
                    item.setAutoOrder(false);
                    itemService.saveItem(item);
                }
            }

            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }       
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable Integer id, @RequestBody Supplier modSupplier) {
        Optional<Supplier> optional = supplierService.findSupplierById(id);
        if (optional.isPresent()) {
            supplierService.saveSupplier(modSupplier);
            return new ResponseEntity<>(modSupplier, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
