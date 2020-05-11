package com.example.consumerest.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {

	@JsonAlias({ "empNo" })
	@JsonProperty("empNo")
	private String employeeId;
	
	@JsonAlias({ "empName" })
	@JsonProperty("empName")
	private String employeeName;
	
	@JsonAlias({ "position" })
	@JsonProperty("position")
	private String employeeRole;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}

	@Override
	public String toString() {
		return "Employee{" + "name=" + employeeName + ", role=" + employeeRole + "}";
	}
}

