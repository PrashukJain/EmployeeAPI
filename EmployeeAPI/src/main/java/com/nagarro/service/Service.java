package com.nagarro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nagarro.entities.EmployeeEntity;
import com.nagarro.repository.EmployeeRepository;
import java.util.*;

@org.springframework.stereotype.Service
public class Service {
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<EmployeeEntity> getAllEmployee() {
		return (List<EmployeeEntity>) this.employeeRepository.findAll();
	}

	public void createUser(@RequestBody EmployeeEntity employee) {
		this.employeeRepository.save(employee);
	}

	public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity employee) {
		return this.employeeRepository.save(employee);
	}

	public void delete(int id) {
		Optional<EmployeeEntity> option = this.employeeRepository.findById(id);
		EmployeeEntity employee = option.get();
		this.employeeRepository.delete(employee);

	}

}
