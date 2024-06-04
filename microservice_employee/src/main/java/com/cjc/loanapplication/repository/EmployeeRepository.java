package com.cjc.loanapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.loanapplication.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
	public Employee findByUserNameAndPassword(String username, String password);

    public Employee findByEmployeeName(String employeeName);
}
