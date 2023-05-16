package com.demo.service;

import java.util.List;

import com.demo.entity.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employee);

	Employee updateEmployee(Long id,Employee employee);

	List<Employee> getAllEmployee();

	Employee getEmployeeById(long id);

	String deleteEmployee(long id);
}
