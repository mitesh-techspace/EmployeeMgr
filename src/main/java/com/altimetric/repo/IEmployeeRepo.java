package com.altimetric.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.altimetric.entity.Employee;


public interface IEmployeeRepo extends JpaRepository<Employee, String>{

	
}
