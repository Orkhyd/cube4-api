package edu.cesi.cube4.controller;

import edu.cesi.cube4.model.Category;
import edu.cesi.cube4.model.Item;
import edu.cesi.cube4.model.Supplier;
import edu.cesi.cube4.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        return categoryService.findAllCategories();
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.saveCategory(category), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable("id") Integer category) {
        Optional<Category> optional = categoryService.findCategoryById(category);
        if (optional.isPresent()) {
            categoryService.deleteCategory(optional.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }       
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Integer id, @RequestBody Category modCategory) {
        return categoryService.updateCategory(id, modCategory);
    }
}
