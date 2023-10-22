package com.infinite.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infinite.spring.model.Employee;
import com.infinite.spring.repository.EmployeeDaoImpl;


@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
    EmployeeDaoImpl cdo;

	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return cdo.getAllEmployees();
	}

	@Transactional
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return cdo.getEmployee(id);
	}

	@Transactional
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		 cdo.addEmployee(employee);
	}

	@Transactional
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		cdo.updateEmployee(employee);
	}

	@Transactional
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		cdo.deleteEmployee(id);
	}

}