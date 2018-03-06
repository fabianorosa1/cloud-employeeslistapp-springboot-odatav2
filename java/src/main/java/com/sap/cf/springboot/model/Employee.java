package com.sap.cf.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author fabiano.rosa
 *
 */

@Entity
@Table(name = "\"MainEntities.Employee\"")
@Data
@NoArgsConstructor
public class Employee implements Serializable {
	private static final long serialVersionUID = 12153453425L;

	@Id
	@SequenceGenerator(name="Employee_GENERATOR", sequenceName="\"employeeSeqId\"", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Employee_GENERATOR")
	@Column(name = "\"id\"")
	private Integer id;

	@Column(name = "\"firstName\"", length = 100)
	private String firstName;

	@Column(name = "\"lastName\"", length = 100)
	private String lastName;
}