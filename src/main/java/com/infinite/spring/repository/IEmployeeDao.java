package com.infinite.spring.repository;

import java.util.List;

import com.infinite.spring.model.Employee;
public interface IEmployeeDao {
	public List<Employee> getAllEmployees() ;
	public Employee getEmployee(int id) ;
	public Employee addEmployee(Employee employee);
	public void updateEmployee(Employee employee) ;
	public void deleteEmployee(int id) ;
}
