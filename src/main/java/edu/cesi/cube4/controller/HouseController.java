package edu.cesi.cube4.controller;

import edu.cesi.cube4.model.House;
import edu.cesi.cube4.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/houses")
public class HouseController {

    private final HouseService houseService;

    @Autowired
    HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping
    public List<House> getAllHouses() {
        return houseService.findAllHouses();
    }

    @PostMapping
    public ResponseEntity<House> createHouse(@RequestBody House house) {
        House savedHouse = houseService.saveHouse(house);
        return new ResponseEntity<>(savedHouse, HttpStatus.CREATED);
    }

}