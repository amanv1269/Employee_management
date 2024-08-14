package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.reposatory.EmployeeReposatory;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeReposatory employeeReposatory;

	public void addEmp(Employee e) {

		employeeReposatory.save(e);
	}

	public List<Employee> getallEmployees() {
		return employeeReposatory.findAll();
	}

	public void deleteEmp(Long id) {
		employeeReposatory.deleteById(id);
	}

	public Employee getEmpById(Long id) {

		Optional<Employee> byId = employeeReposatory.findById(id);
		if (byId.isPresent()) {

			return byId.get();
		}
		return null;
	}

	public void editEmp(Employee emp) {
		employeeReposatory.save(emp);
	}
}
