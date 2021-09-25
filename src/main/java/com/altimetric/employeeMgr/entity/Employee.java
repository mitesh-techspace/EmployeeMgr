package com.altimetric.employeeMgr.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name="Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq")
    @GenericGenerator(
        name = "emp_seq", 
        strategy = "com.altimetric.employeeMgr.entity.IdGeneratorWithPrefix", 
        parameters = {
            @Parameter(name = IdGeneratorWithPrefix.INCREMENT_PARAM, value = "1"),
            @Parameter(name = IdGeneratorWithPrefix.VALUE_PREFIX_PARAMETER, value = "E1"),
            @Parameter(name = IdGeneratorWithPrefix.NUMBER_FORMAT_PARAMETER, value = "%04d") })
	private String empCode;
	
	private String name;
	
	//emp - dept relation
	
	public String getEmpCode() {
		return empCode;
	}

	public String getName() {
		return name;
	}

	public List<Department> getDepartmentsForEmp() {
		return departmentsForEmp;
	}

	public List<Project> getEmpProjects() {
		return empProjects;
	}

	@ManyToMany
	@JoinTable(
			name = "emp_dept",
			joinColumns=@JoinColumn(name="empCode"),
			inverseJoinColumns = @JoinColumn(name="departcode")
			)
	private List <Department> departmentsForEmp = new ArrayList<>();
	
	public void addDepartment(Department department) {
		departmentsForEmp.add(department);
		
	}
	
	public List<Department> getDepartments(){
		return departmentsForEmp;
	}
	
	//emp - proj relation
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(
			name = "emp_proj",
			joinColumns=@JoinColumn(name="empCode",referencedColumnName="empCode"),
			inverseJoinColumns = @JoinColumn(name="projCode",referencedColumnName="projCode")
			)
	private List<Project> empProjects = new ArrayList<>();
	
	public void addProject(Project proj) {
		empProjects.add(proj);
		
	}
	
	
	public Employee() {
		
	}
	
	public Employee(String name) {
		this.name = name;
	}
	
	public Employee(String name, List<Project> projects) {
		this.name = name;
		empProjects = projects;
	}
	
	public List < Project > getProjects() {
        return empProjects;
    }

    public void setProjects(List < Project > projects) {
        this.empProjects = projects;
    }
	

    @Override
    public String toString() {
        return "EmployeeDetails [empcode=" + empCode + ", Name=" + name + 
                ", projects=" + empProjects.toString() + ", departments=" + departmentsForEmp.toString()   + "]";
    }
    
   
    
}
