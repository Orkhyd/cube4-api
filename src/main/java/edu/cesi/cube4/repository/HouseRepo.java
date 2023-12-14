package edu.cesi.cube4.repository;

import edu.cesi.cube4.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepo extends JpaRepository<House,Integer> {
}
