package employ.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import employ.entity.Employee;
import employ.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
//
	@PostMapping("/api/employees")  // /api/employees
	public String addEmployee(@RequestBody Employee employee) {
		 String msg=service.saveEmployee(employee);
		 return msg;
	}
	
	@GetMapping("/api/employees")     //   /api/employees
	public List<Employee> findAllEmployees(){
		return service.getEmployees();
	}
	
	
	@GetMapping("/api/employees/{id}")    //  /api/employees/{id}
	public Employee findEmployeeById(@PathVariable int id) {
		return service.getEmployeeById(id);
	}
	
	@PutMapping(" /api/employees")       //   /api/employees
	public Employee UpdateEmployee(@RequestBody Employee employee) {
		return service.updateEmployee(employee);
	}
	
	@DeleteMapping("/api/employees/{id}")    //   /api/employees/{id}
	public String DeleteEmployee(@PathVariable int id) {
		return service.deleteEmployeeById(id);
	}
	
	
	
	
	

}
