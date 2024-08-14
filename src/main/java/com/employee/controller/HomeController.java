package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

import jakarta.servlet.http.HttpSession;

@Controller
class HomeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/home")
	public String getAllEmp(Model m, HttpSession session) {
		List<Employee> emp = employeeService.getallEmployees();
		m.addAttribute("emp", emp);

		// Optionally, add the message to the model and then remove it from the session
		String msg = (String) session.getAttribute("msg");
		if (msg != null) {
			m.addAttribute("msg", msg);
			session.removeAttribute("msg");
		}

		return "index";
	}

	@GetMapping("/add_emp")
	public String add() {

		return "add_emp";
	}

	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee emp, HttpSession session) {
		employeeService.addEmp(emp);
		System.out.println(emp);
		session.setAttribute("msg", "Employee Added Succesfully");

		return "redirect:/home";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable Long id) {

		employeeService.deleteEmp(id);
		return "redirect:/home";
	}

	@GetMapping("/edit/{id}")
	public String putMethodName(@PathVariable Long id, Model m) {
		Employee e = employeeService.getEmpById(id);
		m.addAttribute("emp", e);
		return "editEmp";
	}

	@PostMapping("/edit")
	public String updateEmp(@ModelAttribute Employee emp, HttpSession session) {
		employeeService.addEmp(emp);
		System.out.println(emp);
		session.setAttribute("msg", "Employee updated Succesfully");

		return "redirect:/home";
	}

}
