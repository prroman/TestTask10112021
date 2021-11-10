package com.rpr.botscrew.university.universityconsole.interfaces;

public interface ConsoleCommands {

    String getDepartmentHead(String departmentName);
    String getDepartmentStatistic(String departmentName);
    String getDepartmentAverageSalary(String departmentName);
    String getDepartmentEmployeeCount(String departmentName);
    String globalSearch(String template);
}
