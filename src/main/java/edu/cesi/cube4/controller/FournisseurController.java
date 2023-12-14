package edu.cesi.cube4.controller;

import edu.cesi.cube4.model.Supplier;
import edu.cesi.cube4.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class FournisseurController {

    private final FournisseurService fournisseurService;

    @Autowired FournisseurController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @GetMapping
    public List<Supplier> getAllFournisseurs() {
        return fournisseurService.findAllSuppliers();
    }

    @PostMapping
    public ResponseEntity<Supplier> createFournisseur(@RequestBody Supplier supplier) {
        Supplier savedSupplier = fournisseurService.saveSupplier(supplier);
        return new ResponseEntity<>(savedSupplier, HttpStatus.CREATED);
    }

}
