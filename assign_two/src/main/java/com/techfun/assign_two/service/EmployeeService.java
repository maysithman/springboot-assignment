package com.techfun.assign_two.service;

import java.util.List;

import com.techfun.assign_two.model.Employee;

public interface EmployeeService {
	
public void createEmployee(Employee employee);
	
	public List<Employee> searchEmployee(Employee employee);
	
	public List<Employee> searchEmployeeByName(String name);
	
	public List<Employee> selectAllEmployee();
	
	public Employee findByEmployeeId(Integer id);
	
	public void updateEmployee(Employee employee);
	
	public void deleteEmployee(Integer id);

}
