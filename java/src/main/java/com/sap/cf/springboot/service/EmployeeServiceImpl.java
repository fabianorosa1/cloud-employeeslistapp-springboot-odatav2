package com.sap.cf.springboot.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sap.cf.springboot.model.Employee;
import com.sap.cf.springboot.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author fabiano.rosa
 *
 */

@Service
@Slf4j
public class EmployeeServiceImpl implements IEmployeeService {
	
	@PersistenceContext
	EntityManager em;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAllByFirstName(String firstName) {
		log.info(">>> findAllByFirstName");

		List<Employee> employees = (List<Employee>) employeeRepository.findAll();
		return employees;
	}

	@Override
	public Employee findOneById(Integer id) {
		log.info(">>> findOneById: " + id);

		Employee employee = this.employeeRepository.findOne(id);
		log.info(">>> employee: " + employee);

		return employee;
	}

	@Override
	@Transactional
	public Employee create(Employee employee) {
		log.info(">>> create: " + employee);
		log.info(">>> EntityManager: " + this.em);

		Employee emp = this.employeeRepository.save(employee);
		// this.employeeRepository.flush();

		return emp;
	}

	@Override
	public List<Employee> findAll() {
		log.info(">>> findAll");

		List<Employee> employees = (List<Employee>) employeeRepository.findAll();
		log.info(">>> employees: " + employees);

		return employees;
	}
}
