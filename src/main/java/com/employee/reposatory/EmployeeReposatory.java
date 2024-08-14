package com.employee.reposatory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;

@Repository
public interface EmployeeReposatory extends JpaRepository<Employee, Long> {

}
