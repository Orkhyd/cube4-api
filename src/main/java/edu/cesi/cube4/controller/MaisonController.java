package edu.cesi.cube4.controller;

import edu.cesi.cube4.model.Article;
import edu.cesi.cube4.model.Maison;
import edu.cesi.cube4.service.MaisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maisons")
public class MaisonController {

    private final MaisonService maisonService;

    @Autowired MaisonController(MaisonService maisonService) {
        this.maisonService = maisonService;
    }

    @GetMapping
    public List<Maison> getAllMaisons() {
        return maisonService.findAllMaisons();
    }

    @PostMapping
    public ResponseEntity<Maison> createMaison(@RequestBody Maison maison) {
        Maison savedMaison = maisonService.saveMaison(maison);
        return new ResponseEntity<>(savedMaison, HttpStatus.CREATED);
    }

}
