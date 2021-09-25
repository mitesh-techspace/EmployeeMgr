package com.altimetric.employeeMgr;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.altimetric.employeeMgr.entity.Employee;
import com.altimetric.employeeMgr.entity.Project;
import com.altimetric.employeeMgr.repo.IProjectRepo;



@RestController
public class EmployeeController {
	
	@Autowired
	IProjectRepo projectRepo;
	
	@GetMapping("/employees")
	public ResponseEntity<String> getCustomer(@RequestParam String projectId) {
		
		Optional<Project> proj = projectRepo.findById(projectId);
		
		if(proj.isPresent()) {
			return new ResponseEntity<>(proj.get().getEmployees().toString(), HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		
		
	}
	
	@DeleteMapping("/employees/{projid}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable String id) {	
		projectRepo.deleteById(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
	}
	
	

}
