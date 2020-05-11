package com.conferencedemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.conferencedemo.model.Employee;
import com.conferencedemo.service.EmployeeService;

@RestController
public class MainRESTController {

	@Autowired
	private EmployeeService employeeService;

	@Value("${dbname:noWork}")
	private String dbName;
	
	@RequestMapping("/")
	public String welcome() {
		return "Welcome to RestTemplate Demo." + dbName;
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public List<Employee> listEmployees(){
		return employeeService.findAll();
	}
	

	// URL - http://localhost:8080/employee/{empNo}
	@RequestMapping(value = "/employee/{empNo}", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public Employee getEmployee(@PathVariable("empNo") String empNo) {
		return employeeService.findEmployee(empNo);
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
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}
	
	@RequestMapping(value = "/employee/{empNo}", 
			method = RequestMethod.DELETE,
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public void deleteEmployee(@PathVariable("empNo") String empNo) {
		employeeService.deleteEmployee(empNo);
	}
}