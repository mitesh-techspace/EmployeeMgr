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
import javax.persistence.ManyToOne;
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
	
	public String getProjCode() {
		return projCode;
	}

	public String getProjName() {
		return projName;
	}

	public List<Department> getDepartmentsOfProj() {
		return departmentsOfProj;
	}

	private String projName;
	
	public Project() {
		
	}
	
	public Project(String name,List<Department> departmentList) {
		this.projName = name;
		departmentsOfProj = departmentList;
	}
	
	public Project(String name,Department department) {
		this.projName = name;
		addDepartment(department);
	}
	
	//emp - project
	@ManyToMany(mappedBy = "empProjects", cascade = { CascadeType.ALL })
	private List<Employee> empsInProj = new ArrayList<Employee>();
	
	private void addEmployee(Employee employee) {
		empsInProj.add(employee);
	}
	
	public List<Employee> getEmployees(){
		return empsInProj;
	}
	
	// project department
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(
			name = "proj_department",
			joinColumns=@JoinColumn(name="projCode", referencedColumnName = "projCode"),
			inverseJoinColumns = @JoinColumn(name="departcode",referencedColumnName = "departcode")
			)
	private List<Department> departmentsOfProj = new ArrayList<Department>();
	
	public List<Department> getDepartments() {
		return departmentsOfProj;
	}
	
	public void setDepartment(List<Department> departmentList) {
		departmentsOfProj = departmentList;
	}
	private void addDepartment(Department department) {
		departmentsOfProj.add(department);
	}
	
	
	@Override
    public String toString() {
        return " [name=" + projName + ", code=" + projCode +"]";
    }
	
	
	
	
	

}
