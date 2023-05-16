package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entity.Employee;
import com.demo.exception.ResourceNotFoundException;
import com.demo.repository.EmployeeRepository;

@Service
@Transactional 
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Long id,Employee employee) {
		Optional<Employee> employeeDb = employeeRepository.findById(id);
		if (employeeDb.isPresent()) {
			Employee employeeUpdate = employeeDb.get();
			employeeUpdate.setId(employee.getId());
			employeeUpdate.setFirstName(employee.getFirstName());
			employeeUpdate.setLastName(employee.getLastName());
			employeeUpdate.setEmail(employee.getEmail());
			employeeUpdate.setAge(employee.getAge());
			return employeeUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with This Id " + employee.getId());
		}
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> employeeDb = employeeRepository.findById(id);
		if (employeeDb.isPresent()) {
			return employeeDb.get();
		} else {
			throw new ResourceNotFoundException("Record not found with This Id " + id);
		}
	}

	@Override
	public String deleteEmployee(long id) {
		Optional<Employee> employeeDb = employeeRepository.findById(id);
		if (employeeDb.isPresent()) {
			employeeRepository.delete(employeeDb.get());
			return "Deleted Corresponding entry from the Database";
		} else {
			throw new ResourceNotFoundException("Record not found with This Id " + id);
		}
	}

}
