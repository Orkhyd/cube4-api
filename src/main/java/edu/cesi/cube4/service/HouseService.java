package edu.cesi.cube4.service;

import edu.cesi.cube4.model.Category;
import edu.cesi.cube4.model.House;
import edu.cesi.cube4.model.Supplier;
import edu.cesi.cube4.repository.HouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseService {
    private final HouseRepo houseRepo;

    @Autowired
    public HouseService(HouseRepo houseRepo) {
        this.houseRepo = houseRepo;
    }

    public ResponseEntity<List<House>> findAllHouses() {
        List<House> houseList = houseRepo.findAll();
        return new ResponseEntity<>(houseList, HttpStatus.OK);
    }
    public House deleteHouse(House house) {
        house.setIsDeleted(true);
        return houseRepo.save(house);
    }

    public House saveHouse(House house) {
        return houseRepo.save(house);
    }

    public Optional<House> findHouseById(Integer id) { return houseRepo.findById(id);}

}
