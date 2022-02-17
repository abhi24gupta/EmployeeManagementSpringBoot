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

	@PostMapping("/api/departments")      //  /api/departments
	public Department addDepartment(@RequestBody Department department) {
		
		return departmentService.addDepartment(department);
	}

	@GetMapping("/api/departments")        //  /api/departments
	public List<Department> getDepartments(){
		return departmentService.getDepartments();
	}

	@GetMapping("/api/departments/{id}")    //  /api/departments/{id}
	public Department getDepartment(@PathVariable int id){
		return departmentService.getDepartment(id);
	}

	@PutMapping("/api/departments/{id}")        //    /api/departments
	public Department updateDepartment(@RequestBody Department department,@PathVariable int id){
		return departmentService.updateDepartment(department,id);
	}

	@DeleteMapping("/api/departments/{id}")
	public String deleteDepartment(@PathVariable int id){
		return departmentService.deleteDepartment(id);
	}



}
