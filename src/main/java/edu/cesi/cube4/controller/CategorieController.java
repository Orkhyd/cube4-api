package edu.cesi.cube4.controller;

import edu.cesi.cube4.model.Categorie;
import edu.cesi.cube4.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategorieController {

    private final CategorieService categorieService;

    @Autowired CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping
    public List<Categorie> getAllCategories() {
        return categorieService.findAllCategories();
    }

    @PostMapping
    public ResponseEntity<Categorie> createCategorie(@RequestBody Categorie categorie) {
        Categorie savedCategorie = categorieService.saveCategorie(categorie);
        return new ResponseEntity<>(savedCategorie, HttpStatus.CREATED);
    }

}
