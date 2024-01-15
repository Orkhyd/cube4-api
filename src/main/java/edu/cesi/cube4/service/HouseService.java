package edu.cesi.cube4.service;

import edu.cesi.cube4.model.Category;
import edu.cesi.cube4.model.House;
import edu.cesi.cube4.repository.HouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<House> findAllHouses() {
        return houseRepo.findAll();
    }

    public House saveHouse(House house) {
        return houseRepo.save(house);
    }

    public Optional<House> findHouseById(Integer id) { return houseRepo.findById(id);}

}
