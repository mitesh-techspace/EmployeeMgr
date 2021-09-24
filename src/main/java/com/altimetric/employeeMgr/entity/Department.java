package com.altimetric.employeeMgr.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;



@Entity
@Table(name="Department")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dep_seq")
    @GenericGenerator(
        name = "dep_seq", 
        strategy = "com.altimetric.employeeMgr.entity.IdGeneratorWithPrefix", 
        parameters = {
            @Parameter(name = IdGeneratorWithPrefix.INCREMENT_PARAM, value = "1"),
            @Parameter(name = IdGeneratorWithPrefix.VALUE_PREFIX_PARAMETER, value = "D1"),
            @Parameter(name = IdGeneratorWithPrefix.NUMBER_FORMAT_PARAMETER, value = "%04d") })
	private String departcode;
	
	private String departName;
	
	public Department(String departmentName) {
		this.departName = departmentName;
	}
	
	//dep-emp relation
	
	@ManyToMany(mappedBy = "departmentsForEmp")
	private List<Employee> employeesInDep = new ArrayList<>();
	
	
	public void addEmployee(Employee emp) {
		employeesInDep.add(emp);
	}
	
	//dep-proj relation
	@ManyToMany(mappedBy = "departmentsInProj")
	private List<Project> projInDep = new ArrayList<>();
	
	
	public void addProj(Project proj) {
		projInDep.add(proj);
	}
	
	
	
	

}
