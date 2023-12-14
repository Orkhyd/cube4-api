package edu.cesi.cube4.repository;

import edu.cesi.cube4.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepo extends JpaRepository<Status,Integer> {
}
