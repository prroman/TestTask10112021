package com.rpr.botscrew.university.universityconsole.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.rpr.botscrew.university.universityconsole.interfaces.ConsoleCommands;
import com.rpr.botscrew.university.universityconsole.model.Degree;
import com.rpr.botscrew.university.universityconsole.model.Department;
import com.rpr.botscrew.university.universityconsole.model.Lector;
import com.rpr.botscrew.university.universityconsole.repository.DepartmentRepository;
import com.rpr.botscrew.university.universityconsole.repository.LectorRepository;

@Primary
@Service
public class ConsoleCommandsImpl implements ConsoleCommands {
	
	private final LectorRepository lectorRepository;
	private final DepartmentRepository departmentRepository;

	public ConsoleCommandsImpl(LectorRepository lectorRepository, DepartmentRepository departmentRepository) {
		this.lectorRepository = lectorRepository;
		this.departmentRepository = departmentRepository;
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

	@Override
	public String getDepartmentHead(String departmentName) {
		Department d = departmentRepository.findByName(departmentName);
		return "Head of " + departmentName + " department is: " + lectorRepository.findByName(d.getHead().getName()).getName();
	}

	@Override
	public String getDepartmentStatistic(String departmentName) {
		int assistantCount = countLectorsByDepartmentNameAndDegree(departmentName, Degree.assistant);
		int associateProfessorCount = countLectorsByDepartmentNameAndDegree(departmentName, Degree.associate_professor);
		int professorCount = countLectorsByDepartmentNameAndDegree(departmentName, Degree.professor);
		return "assistants - " + assistantCount + "\n" 
				+ "associate professors - " + associateProfessorCount + "\n" 
				+ "professors - " + professorCount ;
	}

	@Override
	public String getDepartmentAverageSalary(String departmentName) {
		Department d = departmentRepository.findByName(departmentName);
		List<Lector> l = lectorRepository.findByDepartments(d);
		double averageSalary = 0.00;
		for (int i = 0; i < l.size(); i++) {
			averageSalary += l.get(i).getSalary();
		}
		averageSalary = averageSalary / l.size();
		return "The average salary of " + departmentName + " is " + String.format("%.2f", averageSalary);
	}

	@Override
	public String getDepartmentEmployeeCount(String departmentName) {
		Department d = departmentRepository.findByName(departmentName);
		return String.valueOf(lectorRepository.findByDepartments(d).size());
	}

	@Override
	public String globalSearch(String template) {
		List<Lector> l = lectorRepository.findAllByNameContainsIgnoreCase(template);
		StringBuilder sb = new StringBuilder();
		String loopDelim = "";
		String delim = ",";
		for (int i = 0; i < l.size(); i++) {
			sb.append(loopDelim);
			sb.append(l.get(i).getName());
			loopDelim = delim;
		}
		return sb.toString();
	}

}
