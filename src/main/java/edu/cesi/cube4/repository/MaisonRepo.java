package edu.cesi.cube4.repository;

import edu.cesi.cube4.model.Admin;
import edu.cesi.cube4.model.Maison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaisonRepo extends JpaRepository<Maison,Integer> {
}
