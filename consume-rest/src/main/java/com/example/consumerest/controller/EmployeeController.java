package com.example.consumerest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.consumerest.model.Employee;
import com.example.consumerest.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = "employees",method = RequestMethod.GET)   // or use @GetMapping
    public java.util.List<Employee> listEmployee() {
        return employeeService.getAllEmployees();
    }

	@RequestMapping(value = "/employee", 
			method = RequestMethod.POST, //
			consumes = { MediaType.APPLICATION_JSON_VALUE })
	public String addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}

	@RequestMapping(value = "/employee", 
			method = RequestMethod.PUT, 
			consumes = { MediaType.APPLICATION_JSON_VALUE })
	public String updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}
	
	@RequestMapping(value = "/employee/{empNo}", 
			method = RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable("empNo") String empNo) {
		employeeService.deleteEmployee(empNo);
	}
}
