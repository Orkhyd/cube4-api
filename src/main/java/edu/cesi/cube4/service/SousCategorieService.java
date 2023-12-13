package edu.cesi.cube4.service;

import edu.cesi.cube4.model.SousCategorie;
import edu.cesi.cube4.repository.SousCategorieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SousCategorieService {
    private final SousCategorieRepo sousCategorieRepo;

    @Autowired
    public SousCategorieService(SousCategorieRepo sousCategorieRepo) {
        this.sousCategorieRepo = sousCategorieRepo;
    }

    public List<SousCategorie> findAllSubCategories() {
        return sousCategorieRepo.findAll();
    }

    public  SousCategorie saveSubCategorie(SousCategorie SousCategorie) {
        return sousCategorieRepo.save(SousCategorie);
    }

}
