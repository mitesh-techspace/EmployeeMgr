package com.altimetric.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name="Department")
public class Department {
	
	@Id
	private String departcode;
	
	private String departName;
	
	@ManyToMany(mappedBy = "departments")
	private List<Employee> employees = new ArrayList<>();
	
	
	public void addEmployees(Employee emp) {
		employees.add(emp);
	}
	
	
	

}
