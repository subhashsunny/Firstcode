package com.infinite.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.infinite.spring.model.Employee;
import com.infinite.spring.service.EmployeeServiceImpl;



@Controller
public class EmployeeController {
	@Autowired
	EmployeeServiceImpl employeeService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	public String goToHomePage() {
		return "redirect:/getAllEmployees";
	}
	@RequestMapping(value="/getAllEmployees",method = RequestMethod.GET)
	public String getAllEmployees(Model model){
		//model.addAttribute("Employees",new Employee());
		model.addAttribute("Employee",new Employee());
		model.addAttribute("listOfEmployees",employeeService.getAllEmployees());
		return "employeeDetails";
				
	}
	@RequestMapping(value = "/getEmployee/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Employee getEmployeeById(@PathVariable int id) {
		return employeeService.getEmployee(id);
	}

 

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addEmployee(@ModelAttribute("Employee") Employee employee) {	
		if(employee.getId()==0)
		{
			employeeService.addEmployee(employee);
		}
		else
		{	
			employeeService.updateEmployee(employee);
		}
		return "redirect:/getAllEmployees";
	}
	@RequestMapping(value = "/updateEmployee/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateEmployee(@PathVariable("id") int id,Model model) {
		model.addAttribute("employee", this.employeeService.getEmployee(id));
		model.addAttribute("listOfEmployees", this.employeeService.getAllEmployees());
		return "employeeDetails";
	}
	@RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteEmployee(@PathVariable("id") int id) {
		employeeService.deleteEmployee(id);
		return "redirect:/getAllEmployees";

 

	}
}

