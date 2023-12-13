package edu.cesi.cube4.service;

import edu.cesi.cube4.model.Categorie;
import edu.cesi.cube4.repository.CategorieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {
    private final CategorieRepo categorieRepo;

    @Autowired
    public CategorieService(CategorieRepo categorieRepo) {
        this.categorieRepo = categorieRepo;
    }

    public List<Categorie> findAllCategories() {
        return categorieRepo.findAll();
    }

    public  Categorie saveCategorie(Categorie Categorie) {
        return categorieRepo.save(Categorie);
    }

}
