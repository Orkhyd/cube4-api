package edu.cesi.cube4.service;

import edu.cesi.cube4.model.Category;
import edu.cesi.cube4.model.Supplier;
import edu.cesi.cube4.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<List<Category>> findAllCategories() {
        List<Category> categoryList = categoryRepo.findAll();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    public ResponseEntity<Category> deleteCategory(Integer categoryId) {
        Optional<Category> optional = findCategoryById(categoryId);
        if (optional.isPresent()) {
            Category category = optional.get();
            category.setIsDeleted(true);
            categoryRepo.save(category);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public Category saveCategory(Category category) {
        return categoryRepo.save(category);
    }

    public ResponseEntity<Category> updateCategory(Integer id, Category category) {
        Optional<Category> optional = findCategoryById(id);
        if (optional.isPresent()) {
            Category savedCategory = saveCategory(category);
            return new ResponseEntity<>(savedCategory, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public Optional<Category> findCategoryById(Integer id) {
        return categoryRepo.findById(id);
    }
}
