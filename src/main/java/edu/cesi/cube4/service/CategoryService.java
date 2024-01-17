package edu.cesi.cube4.service;

import edu.cesi.cube4.model.Category;
import edu.cesi.cube4.model.Supplier;
import edu.cesi.cube4.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Category deleteCategory(Category category) {
        category.setIsDeleted(true);
        return categoryRepo.save(category);
    }

    public Category saveCategory(Category category) {
        return categoryRepo.save(category);
    }

    public Optional<Category> findCategoryById(Integer id) { return categoryRepo.findById(id);}
}
