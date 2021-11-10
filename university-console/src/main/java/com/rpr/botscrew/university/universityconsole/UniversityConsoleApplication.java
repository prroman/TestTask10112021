package com.rpr.botscrew.university.universityconsole;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.rpr.botscrew.university.universityconsole.controller.UniversityController;

@SpringBootApplication
public class UniversityConsoleApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(UniversityConsoleApplication.class, args);
		UniversityController controller = (UniversityController) ctx.getBean("universityController");
		Scanner scanner;
		boolean working = true;
		while (working) {
			scanner = new Scanner(System.in);
			System.out.println("Enter you question or type exit to terminate program: \n");
			String result = scanner.nextLine();

			if (result.matches("Who is head of department.*")) {
				String[] parts = result.split("\\s+");
				String department = parts[5];
				System.out.println(controller.getDepartmentHead(department));
			}
			if (result.matches("Show.*.*statistics")) {
				String[] parts = result.split("\\s+");
				String department = parts[1];
				System.out.println(controller.getDepartmentStatistic(department));
			}
			if (result.matches("Show the average salary for the department.*")) {
				String[] parts = result.split("\\s+");
				String department = parts[7];
				System.out.println(controller.getDepartmentAverageSalary(department));
			}
			if (result.matches("Show count of employee for.*")) {
				String[] parts = result.split("\\s+");
				String department = parts[5];
				System.out.println(controller.getDepartmentEmployeeCount(department));
			}
			if (result.matches("Global search by.*")) {
				String[] parts = result.split("\\s+");
				String template = parts[3];
				System.out.println(controller.globalSearch(template));
			}
			if (result.matches("exit")) {
				working = false;
				scanner.close();
			}
		}
	}
}
