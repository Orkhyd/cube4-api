package edu.cesi.cube4.controller;

import edu.cesi.cube4.model.House;
import edu.cesi.cube4.service.MaisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/houses")
public class MaisonController {

    private final MaisonService maisonService;

    @Autowired MaisonController(MaisonService maisonService) {
        this.maisonService = maisonService;
    }

    @GetMapping
    public List<House> getAllMaisons() {
        return maisonService.findAllMaisons();
    }

    @PostMapping
    public ResponseEntity<House> createMaison(@RequestBody House house) {
        House savedHouse = maisonService.saveMaison(house);
        return new ResponseEntity<>(savedHouse, HttpStatus.CREATED);
    }

}
