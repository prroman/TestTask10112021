package com.rpr.botscrew.university.universityconsole.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rpr.botscrew.university.universityconsole.interfaces.ConsoleCommands;
import com.rpr.botscrew.university.universityconsole.model.Degree;
import com.rpr.botscrew.university.universityconsole.model.Department;
import com.rpr.botscrew.university.universityconsole.model.Lector;
import com.rpr.botscrew.university.universityconsole.repository.DepartmentRepository;
import com.rpr.botscrew.university.universityconsole.repository.LectorRepository;

@Service
public class UniversityService {

	private final LectorRepository lectorRepository;
	private final DepartmentRepository departmentRepository;

	public UniversityService(LectorRepository lectorRepository, DepartmentRepository departmentRepository) {
		this.lectorRepository = lectorRepository;
		this.departmentRepository = departmentRepository;
	}

	public void showDepartmentHead(String departmentName) {
		System.out.println();
		System.out.println("Head of " + departmentName + " department is: " + getDepartmentHead(departmentName));
	}

	public void showDepartmentStatistic(String departmentName) {
		System.out.println();
		System.out.println(departmentName + " statistics");
		System.out.println("assistants - " + countLectorsByDepartmentNameAndDegree(departmentName, Degree.assistant));
		System.out.println("associate professor - " + countLectorsByDepartmentNameAndDegree(departmentName, Degree.associate_professor));
		System.out.println("professor - " + countLectorsByDepartmentNameAndDegree(departmentName, Degree.professor));
	}

	public String getDepartmentHead(String department_name) {
		Department d = departmentRepository.findByName(department_name);
		Lector l = lectorRepository.findByName(d.getHead().getName());
		return l.getName();
	}

	public int countLectorsByDepartmentNameAndDegree(String departmentName, Enum<?> degree) {
		Department d = departmentRepository.findByName(departmentName);
		List<Lector> l = lectorRepository.findByDepartments(d);
		List<Lector> result = new ArrayList<Lector>();
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).getDegree().equals(degree)) {
				result.add(l.get(i));
			}
		}
		return result.size();
	}

	public double averageSalaryByDepartmentName(String departmentName) {
		Department d = departmentRepository.findByName(departmentName);
		List<Lector> l = lectorRepository.findByDepartments(d);
		double averageSalary = 0.00;
		for (int i = 0; i < l.size(); i++) {
			averageSalary += l.get(i).getSalary();
		}
		averageSalary = averageSalary / l.size();
		return averageSalary;
	}
}
