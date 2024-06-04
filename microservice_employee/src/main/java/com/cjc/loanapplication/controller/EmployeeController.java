package com.cjc.loanapplication.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.loanapplication.model.Employee;

import com.cjc.loanapplication.servicei.EmployeeService;


import lombok.extern.slf4j.Slf4j;
@CrossOrigin("*")
@Slf4j
@RequestMapping("/employee")
@RestController

public class EmployeeController
{
	@Autowired
	EmployeeService ei;
	@PostMapping(value="/saveEmployee")
	public ResponseEntity<Employee> saveEmployee( @RequestBody Employee e)
	{
		Employee emp=ei.saveEmployee(e);
		if(emp!=null)
		{
			log.info("new Employee data added sucessfully");
			return new ResponseEntity<Employee> (emp,HttpStatus.CREATED);

		}
		else {
			log.error("failed to added data of employee");
			return new ResponseEntity<Employee> (HttpStatus.BAD_REQUEST);
			}
	}
	
	
	
	
	
	@GetMapping(value="/employees/{userName}/{password}")
	public ResponseEntity<Employee>  getEmployeeById(@PathVariable String userName,@PathVariable String password  )
	{ 
		
			Employee emp=ei.findByUsernameAndPasswor(userName,password);
			if(emp!=null)
			{
				log.info("Getting employee data  By username and password Succesfully ");
				return new ResponseEntity<Employee> (emp,HttpStatus.OK);
				
			}
			else {
				log.warn("no any employee  data found");
				return new ResponseEntity<Employee> (HttpStatus.BAD_REQUEST);
			}	
  }
	
	
	
	
	
	@GetMapping(value="/employees")
	public ResponseEntity<List<Employee>> getAllEmployee()
	{
		List<Employee> listEmp=ei.getAllEmployee();
		log.info("Fetch all employee data in from database");
		 return new ResponseEntity<List<Employee>> (listEmp,HttpStatus.CREATED);
		}
	

	
	
	
	
	
	

	
	
}

