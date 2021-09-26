package com.altimetric.employeeMgr.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.altimetric.employeeMgr.entity.Project;


public interface IProjectRepo extends JpaRepository<Project, String>{
	

	
}
