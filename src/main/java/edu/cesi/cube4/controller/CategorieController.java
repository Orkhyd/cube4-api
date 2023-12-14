package edu.cesi.cube4.controller;

import edu.cesi.cube4.model.Category;
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
    public List<Category> getAllMaisons() {
        return categorieService.findAllCategories();
    }

    @PostMapping
    public ResponseEntity<Category> createCategorie(@RequestBody Category category) {
        Category savedCategory = categorieService.saveCategorie(category);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

}
