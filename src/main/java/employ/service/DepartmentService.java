package employ.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import employ.entity.Department;
import employ.repository.DepartmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

	@Autowired
	public DepartmentRepository departmentRepository;
	
	public Department addDepartment(Department department) {
		
		 return departmentRepository.save(department);
		
	}


    public List<Department> getDepartments() {
		return departmentRepository.findAll();
    }


	public Optional<Department> getDepartment(int id) {
		return departmentRepository.findById(id);
	}

	public Department updateDepartment(Department department) {
//		Department existingDepartment = departmentRepository.findById(department.getDepId()).orElse(null);
//		existingDepartment.setDepId(department.getDepId());
//		existingDepartment.setDepName(department.getDepName());
		return departmentRepository.save(department);
	}

	public DepartmentService(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	public String deleteDepartment(int id) {
		if(departmentRepository.existsById(id)){
			this.departmentRepository.deleteById(id);
			return "Department Data Deleted With DepartmentID " + id;
		}
		else {
			return "NO Department Found With DepartmentID " + id;
		}
	}
}
