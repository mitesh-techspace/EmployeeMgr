package com.altimetric.employeeMgr;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.altimetric.employeeMgr.entity.Department;
import com.altimetric.employeeMgr.entity.Employee;
import com.altimetric.employeeMgr.entity.Project;
import com.altimetric.employeeMgr.repo.IEmployeeRepo;

@SpringBootApplication
public class EmployeeMgrApplication implements CommandLineRunner{

	@Autowired
    private IEmployeeRepo empRepository;
	
	
	
	public static void main(String[] args) {
		
		SpringApplication.run(EmployeeMgrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//create department
		Department department = new Department("AltiDepart1");
		
		//create projects
		Project proj1 = new Project("AltimetricProj1",department);
		Project proj2 = new Project("AltimetricProj2",department);
		List<Project> projList = new ArrayList<>();
		projList.add(proj1);
		projList.add(proj2);
		
		department.addProj(proj1);
		department.addProj(proj2);
		
		//create employee and add project references to the employee
		Employee emp1 = new Employee("Mitesh");
		emp1.getProjects().add(proj1);
		emp1.getProjects().add(proj2);
		
		//add employee reference to projects
		proj1.getEmployees().add(emp1);
		proj2.getEmployees().add(emp1);
		
		
		//add department reference to employees
		emp1.getDepartments().add(department);
		
		empRepository.save(emp1);
		
	}

}
