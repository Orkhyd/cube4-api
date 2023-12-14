package edu.cesi.cube4.repository;

import edu.cesi.cube4.model.ActionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogActionRepo extends JpaRepository<ActionLog,Integer> {
}
