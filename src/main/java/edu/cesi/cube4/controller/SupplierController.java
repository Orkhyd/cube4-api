package edu.cesi.cube4.controller;

import edu.cesi.cube4.model.Category;
import edu.cesi.cube4.model.Supplier;
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

    @Autowired
    SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
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
