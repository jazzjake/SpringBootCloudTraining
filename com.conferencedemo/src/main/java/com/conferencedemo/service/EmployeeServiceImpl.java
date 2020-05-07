package com.conferencedemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conferencedemo.model.Employee;
import com.conferencedemo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findEmployee(String empNo) {
		return employeeRepository.findById(empNo).orElse(null);
	}
	
	@Override
	public String addEmployee(Employee employee) {
		employee.setEmpNo(null);      // let mongo assign empNo on an add
		Employee savedEmployee = employeeRepository.save(employee);
		return savedEmployee.getEmpNo();
	}
	
	@Override
	public Employee updateEmployee(Employee employee) {
		Employee savedEmployee = employeeRepository.save(employee);
		return savedEmployee;
	}
	
	@Override
	public void deleteEmployee(String empNo) {
		employeeRepository.deleteById(empNo);
	}
}
