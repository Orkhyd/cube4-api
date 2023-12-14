package edu.cesi.cube4.controller;

import edu.cesi.cube4.model.SubCategory;
import edu.cesi.cube4.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subcategories")
public class SubCategoryController {

    private final SubCategoryService subCategoryService;

    @Autowired
    SubCategoryController(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    @GetMapping
    public List<SubCategory> getAllSubCategories() {
        return subCategoryService.findAllSubCategories();
    }

    @PostMapping
    public ResponseEntity<SubCategory> createSubCategory(@RequestBody SubCategory subCategory) {
        SubCategory savedSubCategory = subCategoryService.saveSubCategory(subCategory);
        return new ResponseEntity<>(savedSubCategory, HttpStatus.CREATED);
    }

}
