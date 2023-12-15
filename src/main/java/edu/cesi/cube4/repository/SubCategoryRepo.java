package edu.cesi.cube4.repository;

import edu.cesi.cube4.model.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepo extends JpaRepository<Subcategory,Integer> {
}
