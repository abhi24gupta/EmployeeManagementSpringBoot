package employ.service;

import java.util.List;

import employ.exception.ResouceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import employ.entity.Employee;
import employ.repository.EmployeeRepository;

@Service
@EnableCaching
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;

	
	public String saveEmployee(Employee employee) {
			repository.save(employee);
			return "Employee Added Successfully";
	}
	

	public List<Employee> getEmployees() {
		return repository.findAll();
	}


//	, unless = "#result.age > 23"    // Condition in Caching
	@Cacheable(key="#id",value="empkey")
	public Employee getEmployeeById(int id) {
//		try{
//			return repository.findById(id).get();
//		}
//		catch(Exception e){
//			throw new ResouceNotFoundException("No Data is found with the provided id");
//		}
//		To Test whether the function getEmployeeById is going to the dao layer for the second time when the same api call is made
//		System.out.println("Going to DAO layer");
		return repository.findById(id).orElseThrow(() -> new ResouceNotFoundException("No Employee found with given id=" + id));
	}


	// CacheEvict is used to have the reflected changes also on the Caching when some data is deleted from DB.
	@CacheEvict(key="#id",value="empkey")
	public String deleteEmployeeById(int id) {
		if(repository.existsById(id)){
			repository.deleteById(id);
			return "Employee Data Deleted With EmployeeID " + id;
		}
		else{
			return "NO Employee Found With EmployeeID " + id;
		}
	}

	// CachePut is used to have the reflected changes also on the Caching when some data is updated in DB.
	@CachePut(key="#id",value="empkey")
	public Employee updateEmployee(Employee employee, int id) {
		Employee existingEmployee = repository.findById(id).orElseThrow(() -> new ResouceNotFoundException("No Employee Found To Update by given Id"));
//		Employee existingEmployee = repository.findById(employee.getId()).orElse(null);
		existingEmployee.setFname(employee.getFname());
		existingEmployee.setLname(employee.getLname());
		existingEmployee.setGender(employee.getGender());
		existingEmployee.setAge(employee.getAge());
		existingEmployee.setAddress(employee.getAddress());
		existingEmployee.setEmp_email(employee.getEmp_email());
		existingEmployee.setDesignation(employee.getDesignation());
		existingEmployee.setDepartment(employee.getDepartment());
		return repository.save(existingEmployee);
	}

	public EmployeeService(EmployeeRepository repository) {
		this.repository = repository;
	}
}
