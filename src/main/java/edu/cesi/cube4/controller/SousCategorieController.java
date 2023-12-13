package edu.cesi.cube4.controller;

import edu.cesi.cube4.model.SousCategorie;
import edu.cesi.cube4.service.SousCategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subcategories")
public class SousCategorieController {

    private final SousCategorieService sousCategorieService;

    @Autowired SousCategorieController(SousCategorieService sousCategorieService) {
        this.sousCategorieService = sousCategorieService;
    }

    @GetMapping
    public List<SousCategorie> getAllSubCategories() {
        return sousCategorieService.findAllSubCategories();
    }

    @PostMapping
    public ResponseEntity<SousCategorie> createSousCategorie(@RequestBody SousCategorie sousCategorie) {
        SousCategorie savedSousCategorie = sousCategorieService.saveSubCategorie(sousCategorie);
        return new ResponseEntity<>(savedSousCategorie, HttpStatus.CREATED);
    }

}
