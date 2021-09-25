package com.altimetric.employeeMgr.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.altimetric.employeeMgr.entity.Employee;


public interface IEmployeeRepo extends JpaRepository<Employee, Long>{

	
}
