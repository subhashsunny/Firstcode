package com.infinite.spring.service;

import java.util.List;

import com.infinite.spring.model.Employee;

public interface IEmployeeService {
	public List<Employee> getAllEmployees();

	public Employee getEmployee(int id);

	public void addEmployee(Employee employee);

	public void updateEmployee(Employee employee);

	public void deleteEmployee(int id);
}
