package com.project.service;

import java.util.List;
import java.util.Map;

import com.project.dto.EmployeeDto;
import com.project.entity.Employee;

public interface EmployeeService {

	    List<Employee> getAllEmployees();
	    Employee createEmployee(EmployeeDto employee);
	    Employee getEmployeeById(int id);
	    Employee updateEmployee(int id, EmployeeDto employeeDetails);
	    Map<String, Boolean> deleteEmployee(int id);
}
