package employ.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import employ.entity.Employee;
import employ.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;

	
	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}
	

	public List<Employee> getEmployees() {
		return repository.findAll();
	}
	
	public Employee getEmployeeById(int id) {

		return repository.findById(id).orElse(null);
	}
	
	public String deleteEmployeeById(int id) {
		repository.deleteById(id);
		return "Employee Deleted By ID:" + id;
	}
	// save & merge
	public Employee  updateEmployee(Employee employee) {
		Employee existingEmployee = repository.findById(employee.getId()).orElse(null);
		existingEmployee.setFname(employee.getFname());
		existingEmployee.setLname(employee.getLname());
		existingEmployee.setDesignation(employee.getDesignation());
		return repository.save(existingEmployee);
	}

	public EmployeeService(EmployeeRepository repository) {
		this.repository = repository;
	}
}
