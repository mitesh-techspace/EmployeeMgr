package com.altimetric.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name="Employee")
public class Employee {
	
	@Id
	private String empCode;
	
	private String name;
	
	@ManyToMany
	@JoinTable(
			name = "emp_dept",
			joinColumns=@JoinColumn(name="employee_id"),
			inverseJoinColumns = @JoinColumn(name="department_id")
			)
	private List <Department> departments = new ArrayList<>();
	
	public Employee(String name) {
		this.name = name;
	}
	
	public void addDepartment(Department department) {
		departments.add(department);
		
	}

}
