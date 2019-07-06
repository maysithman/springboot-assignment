package com.techfun.assign_two.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techfun.assign_two.dao.EmployeeDao;
import com.techfun.assign_two.model.Employee;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDao employeeDao;

	@Override
	public void createEmployee(Employee employee) {
		employeeDao.createEmployee(employee);
	}

	@Override
	public List<Employee> searchEmployee(Employee employee) {
		return employeeDao.searchEmployee(employee);
	}

	@Override
	public List<Employee> selectAllEmployee() {
		return employeeDao.selectAllEmployee();
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}

	@Override
	public void deleteEmployee(Integer id) {
		employeeDao.deleteEmployee(id);
	}

	@Override
	public Employee findByEmployeeId(Integer id) {
		return employeeDao.findByEmployeeId(id);
	}

	@Override
	public List<Employee> searchEmployeeByName(String name) {
		return employeeDao.searchEmployeeByName(name);
	}

}
