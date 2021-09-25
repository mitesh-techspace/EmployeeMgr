package com.altimetric.employeeMgr.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.altimetric.employeeMgr.entity.Employee;
import com.altimetric.employeeMgr.entity.Project;


public interface IProjectRepo extends JpaRepository<Project, String>{
	
	//List<Employee> findByProjCode(String projCode);
	//void deleteByProjCode(String projCode);

	
}
