package edu.cesi.cube4.repository;

import edu.cesi.cube4.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Integer> {
    Optional<Admin> findByUsername(String username);

}
