package edu.cesi.cube4.controller;

import edu.cesi.cube4.model.Fournisseur;
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
    public List<Fournisseur> getAllFournisseurs() {
        return fournisseurService.findAllSuppliers();
    }

    @PostMapping
    public ResponseEntity<Fournisseur> createFournisseur(@RequestBody Fournisseur fournisseur) {
        Fournisseur savedFournisseur = fournisseurService.saveSupplier(fournisseur);
        return new ResponseEntity<>(savedFournisseur, HttpStatus.CREATED);
    }

}
