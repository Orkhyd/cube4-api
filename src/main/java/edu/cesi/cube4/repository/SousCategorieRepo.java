package edu.cesi.cube4.repository;

import edu.cesi.cube4.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SousCategorieRepo extends JpaRepository<SubCategory,Integer> {
}
