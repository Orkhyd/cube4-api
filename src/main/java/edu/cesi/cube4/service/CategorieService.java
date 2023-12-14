package edu.cesi.cube4.service;

import edu.cesi.cube4.model.Category;
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

    public List<Category> findAllCategories() {
        return categorieRepo.findAll();
    }

    public Category saveCategorie(Category category) {
        return categorieRepo.save(category);
    }

}
