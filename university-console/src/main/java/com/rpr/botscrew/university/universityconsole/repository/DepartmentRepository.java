package com.rpr.botscrew.university.universityconsole.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rpr.botscrew.university.universityconsole.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	Department findByName(String name);
}
