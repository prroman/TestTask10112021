package com.rpr.botscrew.university.universityconsole.bootstrap;


import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;

import com.rpr.botscrew.university.universityconsole.interfaces.ConsoleCommands;
import com.rpr.botscrew.university.universityconsole.model.Degree;
import com.rpr.botscrew.university.universityconsole.model.Department;
import com.rpr.botscrew.university.universityconsole.model.Lector;
import com.rpr.botscrew.university.universityconsole.repository.DepartmentRepository;
import com.rpr.botscrew.university.universityconsole.repository.LectorRepository;

@Component
public class BootsTrap implements CommandLineRunner {
	
	private final LectorRepository lectorRepository;
	private final DepartmentRepository departmentRepository;

	public BootsTrap(LectorRepository lectorRepository, DepartmentRepository departmentRepository) {
		this.lectorRepository = lectorRepository;
		this.departmentRepository = departmentRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		prepareData();
	}
	
	public void prepareData() {
		Lector lector1 = new Lector("Vasia Pupkin", 1000.00, Degree.assistant);
		Lector lector2 = new Lector("John Doe", 1300.00, Degree.associate_professor);
		Lector lector3 = new Lector("Adam Smith", 1500.00, Degree.professor);
		Lector lector4 = new Lector("Hannah Brown", 1100.00, Degree.assistant);
		Lector lector5 = new Lector("Joseph White", 1150.00, Degree.associate_professor);
		Lector lector6 = new Lector("Monica Green", 1600.00, Degree.professor);
		Lector lector7 = new Lector("Ian Buyer", 1250.00, Degree.assistant);
		Lector lector8 = new Lector("Mike Grand", 1350.00, Degree.associate_professor);
		Lector lector9 = new Lector("Margaret Steier", 1560.00, Degree.professor);
		
		Department department1 = new Department("IT", lector3);
		Department department2 = new Department("Biology", lector6);
		Department department3 = new Department("Law", lector9);
		
		lector1.getDepartments().add(department3);
		lector1.getDepartments().add(department2);
		lectorRepository.save(lector1);
		
		lector2.getDepartments().add(department2);
		lectorRepository.save(lector2);
		
		lector3.getDepartments().add(department1);
		lector3.getDepartments().add(department2);
		lectorRepository.save(lector3);
		
		lector4.getDepartments().add(department3);
		lectorRepository.save(lector4);
		
		lector5.getDepartments().add(department2);
		lector5.getDepartments().add(department3);
		lectorRepository.save(lector5);
		
		lector6.getDepartments().add(department1);
		lectorRepository.save(lector6);
		
		lector7.getDepartments().add(department3);
		lector7.getDepartments().add(department1);
		lectorRepository.save(lector7);
		
		lector8.getDepartments().add(department2);
		lectorRepository.save(lector8);
		
		lector9.getDepartments().add(department1);
		lector9.getDepartments().add(department2);
		lectorRepository.save(lector9);
		
		department1.getLectors().add(lector3);
		department1.getLectors().add(lector6);
		department1.getLectors().add(lector7);
		department1.getLectors().add(lector9);

		department2.getLectors().add(lector1);
		department2.getLectors().add(lector2);
		department2.getLectors().add(lector3);
		department2.getLectors().add(lector5);
		department2.getLectors().add(lector8);
		department2.getLectors().add(lector9);

		department3.getLectors().add(lector1);
		department3.getLectors().add(lector4);
		department3.getLectors().add(lector5);
		department3.getLectors().add(lector7);

		departmentRepository.save(department1);
		departmentRepository.save(department2);
		departmentRepository.save(department3);
	}
}
