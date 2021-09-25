package com.altimetric.employeeMgr.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.altimetric.employeeMgr.entity.Department;

public interface IDepartmentRepo extends JpaRepository<Department, Long>{

}
