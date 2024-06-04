package com.cjc.loanapplication.servicei;

import java.util.List;

import com.cjc.loanapplication.model.Employee;



public interface EmployeeService {

	 public Employee saveEmployee(Employee e);
    public List<Employee> getAllEmployee();
    public Employee findByUsernameAndPasswor(String userName, String password);


}
