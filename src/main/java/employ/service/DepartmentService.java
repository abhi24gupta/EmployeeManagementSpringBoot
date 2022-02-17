package employ.service;

import employ.exception.ResouceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import employ.entity.Department;
import employ.repository.DepartmentRepository;

import java.util.List;
import java.util.Optional;

@Service
@EnableCaching
public class DepartmentService {

	@Autowired
	public DepartmentRepository departmentRepository;
	
	public Department addDepartment(Department department) {
		
		 return departmentRepository.save(department);
		
	}


    public List<Department> getDepartments() {
		return departmentRepository.findAll();
    }

	@Cacheable(key="#id", value="depkey")
	public Department getDepartment(int id) {
		return departmentRepository.findById(id).orElseThrow(() -> new ResouceNotFoundException("No department found with given id :" + id + " to search"));
	}


	@CachePut(key="#id", value="depkey")
	public Department updateDepartment(Department department, int id) {
		Department existingDepartment = departmentRepository.findById(id).orElseThrow(() -> new ResouceNotFoundException("No department Found with given id"+ id ));
		existingDepartment.setDepName(department.getDepName());
		existingDepartment.setDepDesc(department.getDepDesc());
		existingDepartment.setDepLocation(department.getDepLocation());
		return departmentRepository.save(existingDepartment);
	}

	public DepartmentService(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}


	@CacheEvict(key="#id", value="depkey")
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
