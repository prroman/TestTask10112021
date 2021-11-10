package com.rpr.botscrew.university.universityconsole.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rpr.botscrew.university.universityconsole.model.Department;
import com.rpr.botscrew.university.universityconsole.model.Lector;

public interface LectorRepository extends JpaRepository<Lector, Long> {

	Lector findByName(String name);
	List<Lector> findByDepartments(Department d);
	List<Lector> findAllByNameContainsIgnoreCase(String name);
	
}
