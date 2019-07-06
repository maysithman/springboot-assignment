package com.techfun.assign_two.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.techfun.assign_two.mapper.EmployeeMapper;
import com.techfun.assign_two.model.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void createEmployee(Employee employee) {
		String sql = "INSERT INTO employee(name, age, city, email) VALUES(?, ? ,? ,?)";
		jdbcTemplate.update(sql, employee.getName(), employee.getAge(), employee.getCity(), employee.getEmail());
	}

	@Override
	public List<Employee> selectAllEmployee() {
		String sql = "SELECT * FROM employee";
		return jdbcTemplate.query(sql, new EmployeeMapper());
	}

	@Override
	public List<Employee> searchEmployee(Employee employee) {
		String sql = "SELECT * FROM employee WHERE UPPER(name) LIKE UPPER(%?%) OR age = ? OR UPPER(city) LIKE UPPER(%?%)";
		return jdbcTemplate.query(sql, new EmployeeMapper(), employee.getName(), employee.getAge(), employee.getCity());
	}

	@Override
	public void updateEmployee(Employee employee) {
		String sql = "UPDATE employee SET name=?, age=?, city=?, email=? WHERE id=?";
		jdbcTemplate.update(sql, employee.getName(), employee.getAge(), employee.getCity(), employee.getEmail(), employee.getId());
	}

	@Override
	public void deleteEmployee(Integer id) {
		String sql = "DELETE FROM employee WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public Employee findByEmployeeId(Integer id) {
		String sql = "SELECT * FROM employee where id=?";
		Employee result = null;
		try {
			result = jdbcTemplate.queryForObject(sql, new EmployeeMapper(), id);
		} catch (EmptyResultDataAccessException e) {
			// do nothing, return null
		}

		return result;
	}

	@Override
	public List<Employee> searchEmployeeByName(String name) {
		String sql = "SELECT * FROM employee WHERE UPPER(name) LIKE UPPER(%name%)";
		return jdbcTemplate.query(sql, new EmployeeMapper());
	}

	
}
