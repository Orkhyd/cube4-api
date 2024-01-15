package edu.cesi.cube4.service;

import edu.cesi.cube4.model.Category;
import edu.cesi.cube4.model.Subcategory;
import edu.cesi.cube4.repository.SubCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubCategoryService {
    private final SubCategoryRepo subCategoryRepo;

    @Autowired
    public SubCategoryService(SubCategoryRepo subCategoryRepo) {
        this.subCategoryRepo = subCategoryRepo;
    }

    public List<Subcategory> findAllSubCategories() {
        return subCategoryRepo.findAll();
    }

    public Subcategory saveSubCategory(Subcategory SubCategory) {
        return subCategoryRepo.save(SubCategory);
    }

    public Optional<Subcategory> findSubCategoryById(Integer id) { return subCategoryRepo.findById(id);}

}
