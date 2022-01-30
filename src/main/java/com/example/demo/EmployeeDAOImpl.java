package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Employee> findAll() {
		return jdbcTemplate.query("SELECT * FROM employee", new BeanPropertyRowMapper<Employee>(Employee.class));
	}

	@Override
	public Employee findById(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM employee WHERE empid=?", new BeanPropertyRowMapper<Employee>(Employee.class), id);
	}

	@Override
	public int deleteById(int id) {
		return jdbcTemplate.update("DELETE FROM employee WHERE empid=?", id);
	}

	@Override
	public int save(Employee e) {
		return jdbcTemplate.update("INSERT INTO employee (empid, empname, empaddress) VALUES (?, ?, ?)", new Object[] {e.getEmpid(), e.getEmpname(), e.getEmpaddress()});
	}

	@Override
	public int update(Employee e, int id) {
		return jdbcTemplate.update("UPDATE employee SET empid = ?, empname = ?, empaddress = ? WHERE empid = ?", new Object[] {e.getEmpid(), e.getEmpname(), e.getEmpaddress(), id});
	}

}
