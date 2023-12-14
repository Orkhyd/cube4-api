package edu.cesi.cube4.service;

import edu.cesi.cube4.model.Category;
import edu.cesi.cube4.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepo categoryRepo;

    @Autowired
    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public List<Category> findAllCategories() {
        return categoryRepo.findAll();
    }

    public Category saveCategory(Category category) {
        return categoryRepo.save(category);
    }

}
