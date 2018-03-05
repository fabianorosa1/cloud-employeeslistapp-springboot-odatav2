package com.sap.cf.springboot.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sap.cf.springboot.model.Employee;

/**
 * 
 * @author fabiano.rosa
 *
 */

public interface IEmployeeService {

	public List<Employee> findAllByFirstName(String firstName);

	public List<Employee> findAll();

	public Employee findOneById(Integer id);

	@Transactional
	public Employee create(Employee employee);
}
