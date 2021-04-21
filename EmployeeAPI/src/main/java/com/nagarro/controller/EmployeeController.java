package com.nagarro.controller;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.entities.*;
import com.nagarro.repository.EmployeeRepository;
import com.nagarro.service.Service;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	Service service;
	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping
	public List<EmployeeEntity> getAllEmployee() {
		return service.getAllEmployee();
	}

	@PostMapping
	public void createUser(@RequestBody EmployeeEntity employee) {
		service.createUser(employee);
	}

	@PutMapping("/{id}")
	public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity employee, @PathVariable("id") int employeeCode) {
		return service.updateEmployee(employee);
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public void delete(@PathVariable("id") int id) {

		this.service.delete(id);
	}

}
