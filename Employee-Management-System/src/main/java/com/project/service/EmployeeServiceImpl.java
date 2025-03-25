package com.project.service;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.EmployeeDto;
import com.project.entity.Employee;
import com.project.exception.ResourceNotFoundException;
import com.project.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee dtoToEntity(EmployeeDto dto) {
    	Employee employee = new Employee();
    	employee.setFirstName(dto.getFirstName());
    	employee.setLastName(dto.getLastName());
    	employee.setSalary(dto.getSalary());
    	
    	return employee;
    }
    
    @Override
    public List<Employee> getAllEmployees() {
    	 List<Employee> employees = employeeRepository.findAll();
         if (employees.isEmpty()) {
             throw new ResourceNotFoundException("No employees found");
         }
         return employees;
    }

    @Override
    public Employee createEmployee(EmployeeDto dto) {
    	Employee employee =dtoToEntity(dto);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
    	return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
    }

    @Override
    public Employee updateEmployee(int id, EmployeeDto employeeDetails) {
        Employee employee = getEmployeeById(id);
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setSalary(employeeDetails.getSalary());
        return employeeRepository.save(employee);
    }

    @Override
    public Map<String, Boolean> deleteEmployee(int id) {
        Employee employee = getEmployeeById(id);
        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
