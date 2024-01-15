package edu.cesi.cube4.controller;

import edu.cesi.cube4.model.Category;
import edu.cesi.cube4.model.Subcategory;
import edu.cesi.cube4.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subcategories")
public class SubCategoryController {

    private final SubCategoryService subCategoryService;

    @Autowired
    SubCategoryController(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    @GetMapping
    public List<Subcategory> getAllSubCategories() {
        return subCategoryService.findAllSubCategories();
    }

    @PostMapping
    public ResponseEntity<Subcategory> createSubCategory(@RequestBody Subcategory subCategory) {
        Subcategory savedSubcategory = subCategoryService.saveSubCategory(subCategory);
        return new ResponseEntity<>(savedSubcategory, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subcategory> updateSubCategory(@PathVariable Integer id, @RequestBody Subcategory modSubCategory) {
        Optional<Subcategory> optional = subCategoryService.findSubCategoryById(id);
        if (optional.isPresent()) {
            subCategoryService.saveSubCategory(modSubCategory);
            return new ResponseEntity<>(modSubCategory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
