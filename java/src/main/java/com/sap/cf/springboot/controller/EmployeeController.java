package com.sap.cf.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sap.cf.springboot.model.Employee;
import com.sap.cf.springboot.service.IEmployeeService;
import com.sap.xs2.security.container.SecurityContext;
import com.sap.xs2.security.container.UserInfo;
import com.sap.xs2.security.container.UserInfoException;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author fabiano.rosa
 *
 */

@RestController
@Slf4j
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	@GetMapping("/home")
	@ResponseBody
	public String getHome() {
		log.info(">>> GET Home - SERVICE");		
		
		return "SpringBoot Employee List - Home Works !!!!";
	}
	
	@GetMapping("/create")
	@ResponseBody
	public Employee createEmployee() {
		log.info(">>> createEmployee");
		
		Employee employee = new Employee();
		employee.setFirstName("testeFirst-" + this.hashCode());
		employee.setLastName("testeLast-" + this.hashCode());
						
		return employeeService.create(employee);
	}
		
	@GetMapping("/employee/{id}")
	@ResponseBody
	public Employee getEmployeeById(@PathVariable(value = "id") final Integer id) {
		log.info(">>> GET Employee BY ID: " + id);
		
		return employeeService.findOneById(id);
	}
	
	@GetMapping("/employees")
	@ResponseBody
	public List<Employee> getAllEmployees() {
		log.info(">>> GET ALL Employee");
		List<Employee> listEmployee = employeeService.findAll();
		
		return listEmployee;
	}	
	
	/*
	 * https://help.sap.com/viewer/65de2977205c403bbc107264b8eccf4b/Cloud/en-US/be97ec4a799c4135884c62610fea2a8f.html
	 */
	@GetMapping("/info")
	@ResponseBody
	public String getLoginInfo() throws UserInfoException {
		log.info(">>> getLoginInfo");
		
		UserInfo userInfo = SecurityContext.getUserInfo(); 
		log.info("userInfo: " + userInfo);
		
		String name = userInfo.getLogonName(); 
		log.info("name: " + name);
		
		String email = userInfo.getEmail();
		log.info("email: " + email);
		
		//String[] attribute = userInfo.getAttribute("my attribute");
		//log.info("attribute: " + attribute);
		
		boolean hasDeleteScope = userInfo.checkLocalScope("Delete");
		log.info("hasDeleteScope: " + hasDeleteScope);
		
		return name;
	}
}
