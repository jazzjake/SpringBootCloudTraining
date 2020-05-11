package com.example.consumerest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.consumerest.model.Employee;

@Service
public class EmployeeService {
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	public List<Employee> getAllEmployees() {
		RestTemplate restTemplate = new RestTemplate();
		List<Employee> employeeList = new ArrayList<Employee>();
		ResponseEntity<Employee[]> response =
				  restTemplate.getForEntity(
				  "http://localhost:8080/employees",
				  Employee[].class);
				Employee[] employees = response.getBody();
				employeeList = Arrays.asList(employees);
				for(Employee emp : employees) {
					log.info(emp.toString());
				}
		return employeeList;
		
	}
	
	
	public String addEmployee(Employee employee) {
		employee.setEmployeeId(null);      // let mongo assign empNo on an add
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8080/employee", employee, String.class);
		
		return response.getBody();
	}
	
	public String updateEmployee(Employee employee) {

		HttpEntity<Employee> request = new HttpEntity<>(employee);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/employee", HttpMethod.PUT, request, String.class);
		
		return response.getBody();
	}

	public void deleteEmployee(String empNo) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.exchange("http://localhost:8080/employee/" + empNo,
            HttpMethod.DELETE,
            null,
            Void.class);

	}
}
