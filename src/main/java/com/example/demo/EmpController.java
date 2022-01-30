package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmpController {
	
	@Autowired 
	private EmployeeDAO eDAO;

	@GetMapping("/employees/{id}")
	public Employee findById(@PathVariable int id) {
		return eDAO.findById(id);
	}


	@PostMapping("/employees")
	public String save(@RequestBody Employee e) {
		return eDAO.save(e) + " Employee(s) saved successfully";
	}

	@PutMapping("/employees/{id}")
	public String update(@RequestBody Employee e, @PathVariable int id) {
		return eDAO.update(e, id) + " Employee(s) updated successfully";
	}

}
