package com.cjc.loanapplication.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cjc.loanapplication.exception.EmployeeNotSaveExcepiton;
import com.cjc.loanapplication.exception.InvalidEmployeeIdException;
import com.cjc.loanapplication.exception.NoAnyEmployeedataFoundException;
import com.cjc.loanapplication.model.Employee;
import com.cjc.loanapplication.repository.EmployeeRepository;
import com.cjc.loanapplication.servicei.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired
	EmployeeRepository er;

	@Override
	public Employee saveEmployee(Employee e) 
	{
       Employee emp=er.save(e);
		if(emp!=null) 
		{
			return emp;
		}
		else {
			throw new EmployeeNotSaveExcepiton("Unable to save Employee");
		}
	}
	
	
	
	
	
	@Override
	public Employee findByUsernameAndPasswor(String userName, String password) 
	{

		Employee emp=er.findByUserNameAndPassword(userName, password);
	if(emp!=null)
		{
		return emp;
		}
		else {
		throw new InvalidEmployeeIdException("Employee Not Found");		
		}
	}
	
	
	
	
	
	@Override
	public List<Employee> getAllEmployee() {
		List<Employee>list=(List<Employee>) er.findAll();
		if(list.isEmpty())
		{
			throw new NoAnyEmployeedataFoundException("Not found any employees data Found");
		}
		else 
		{
			return list;
		}
	}


	

}
