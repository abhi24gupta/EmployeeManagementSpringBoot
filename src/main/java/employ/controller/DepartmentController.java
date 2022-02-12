package employ.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import employ.entity.Department;
import employ.service.DepartmentService;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {
	
	@Autowired
	public DepartmentService departmentService;

	@PostMapping("/adddepartment")
	public Department addDepartment(@RequestBody Department department) {
		
		return departmentService.addDepartment(department);
	}

	@GetMapping("/departments")
	public List<Department> getDepartments(){
		return departmentService.getDepartments();
	}

	@GetMapping("/department/{id}")
	public Optional<Department> getDepartment(@PathVariable int id){
		return departmentService.getDepartment(id);
	}

	@PutMapping("/department")
	public Department updateDepartment(@RequestBody Department department){
		return departmentService.updateDepartment(department);
	}



}
