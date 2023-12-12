package edu.cesi.cube4.service;

import edu.cesi.cube4.model.Maison;
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

    public List<Maison> findAllMaisons() {
        return maisonRepo.findAll();
    }

    public  Maison saveMaison(Maison maison) {
        return maisonRepo.save(maison);
    }

}
