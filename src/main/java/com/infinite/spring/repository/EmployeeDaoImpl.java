package com.infinite.spring.repository;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Repository;

import com.infinite.spring.model.Employee;

@Repository
@EnableAsync(proxyTargetClass = true)
@EnableCaching(proxyTargetClass = true)
public class EmployeeDaoImpl implements IEmployeeDao {
	@Autowired
	private SessionFactory sfactory;
	
	public void setSfactory(SessionFactory sfactory) {
		this.sfactory = sfactory;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		Session scs=this.sfactory.getCurrentSession();
		List<Employee> ls=scs.createQuery("from Employee").list();
		return ls;
	}

	@Override
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		Session session = this.sfactory.getCurrentSession();
		Employee employee = (Employee) session.get(Employee.class, id);
		return employee;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Session scs = this.sfactory.getCurrentSession();
		scs.save(employee);
		return employee;
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Session session = this.sfactory.getCurrentSession();
		Hibernate.initialize(employee);
		session.update(employee);
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		Session session = this.sfactory.getCurrentSession();
	    Employee p = (Employee) session.load(Employee.class, new Integer(id));
		if (null != p) {
			session.delete(p);
	}

}
}