package com.rpr.botscrew.university.universityconsole.controller;

import org.springframework.stereotype.Controller;

import com.rpr.botscrew.university.universityconsole.interfaces.ConsoleCommands;

@Controller
public class UniversityController {

	private final ConsoleCommands consoleCommands;
	
	public UniversityController(ConsoleCommands consoleCommands) {
		this.consoleCommands = consoleCommands;
	}
	
    public String getDepartmentHead(String departmentName) {
    	return consoleCommands.getDepartmentHead(departmentName);
    }
    public String getDepartmentStatistic(String departmentName) {
    	return consoleCommands.getDepartmentStatistic(departmentName);
    }
    public String getDepartmentAverageSalary(String departmentName) {
    	return consoleCommands.getDepartmentAverageSalary(departmentName);
    }
    public String getDepartmentEmployeeCount(String departmentName) {
    	return consoleCommands.getDepartmentEmployeeCount(departmentName);
    }
    public String globalSearch(String template) {
    	return consoleCommands.globalSearch(template);
    }
}
