package edu.cesi.cube4.service;

import edu.cesi.cube4.model.SubCategory;
import edu.cesi.cube4.repository.SubCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryService {
    private final SubCategoryRepo subCategoryRepo;

    @Autowired
    public SubCategoryService(SubCategoryRepo subCategoryRepo) {
        this.subCategoryRepo = subCategoryRepo;
    }

    public List<SubCategory> findAllSubCategories() {
        return subCategoryRepo.findAll();
    }

    public SubCategory saveSubCategory(SubCategory SubCategory) {
        return subCategoryRepo.save(SubCategory);
    }

}
