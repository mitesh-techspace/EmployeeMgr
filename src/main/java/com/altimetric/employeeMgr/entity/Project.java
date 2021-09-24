package com.altimetric.employeeMgr.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="Project")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "proj_seq")
    @GenericGenerator(
        name = "proj_seq", 
        strategy = "com.altimetric.employeeMgr.entity.IdGeneratorWithPrefix", 
        parameters = {
            @Parameter(name = IdGeneratorWithPrefix.INCREMENT_PARAM, value = "1"),
            @Parameter(name = IdGeneratorWithPrefix.VALUE_PREFIX_PARAMETER, value = "P1"),
            @Parameter(name = IdGeneratorWithPrefix.NUMBER_FORMAT_PARAMETER, value = "%04d") })
	private String projCode;
	
	private String projName;
	
	public Project(String name,Department department) {
		this.projName = name;
		departmentsInProj.add(department);
	}
	
	//emp - project
	@ManyToMany(mappedBy = "empProjects")
	private List<Employee> empsInProj = new ArrayList<Employee>();
	
	private void addEmployee(Employee employee) {
		empsInProj.add(employee);
	}
	
	// project department
	@ManyToMany
	@JoinTable(
			name = "proj_department",
			joinColumns=@JoinColumn(name="project_id"),
			inverseJoinColumns = @JoinColumn(name="department_id")
			)
	private List<Department> departmentsInProj = new ArrayList<>();
	
	public void addDepartment(Department department) {
		departmentsInProj.add(department);
	}
	
	
	
	
	
	

}
