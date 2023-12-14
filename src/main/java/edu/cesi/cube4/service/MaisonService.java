package edu.cesi.cube4.service;

import edu.cesi.cube4.model.House;
import edu.cesi.cube4.repository.MaisonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaisonService {
    private final MaisonRepo maisonRepo;

    @Autowired
    public MaisonService(MaisonRepo maisonRepo) {
        this.maisonRepo = maisonRepo;
    }

    public List<House> findAllMaisons() {
        return maisonRepo.findAll();
    }

    public House saveMaison(House house) {
        return maisonRepo.save(house);
    }

}
