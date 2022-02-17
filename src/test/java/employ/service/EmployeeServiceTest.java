package employ.service;

import employ.entity.Employee;
import employ.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepo;


    private EmployeeService employeeService;

    @Mock
    private Employee employee;

    @BeforeEach
    void setUp() {
       this.employeeService=new EmployeeService(this.employeeRepo);
    }

    @Test
    void saveEmployee() {
        employeeService.saveEmployee(employee);
        verify(employeeRepo).save(employee);
    }

    @Test
    void getEmployees() {
        employeeService.getEmployees();
        verify(employeeRepo).findAll();
    }

    @Test
    void getEmployeeById() {
        employeeService.getEmployeeById(employee.getId());
        verify(employeeRepo).findById(employee.getId());
    }

    @Test
    void deleteEmployeeById() {
        employeeService.deleteEmployeeById(employee.getId());
        verify(employeeRepo).deleteById(employee.getId());
    }

//    @Test
//    void updateEmployee() {
//        employeeService.updateEmployee(employee);
//        verify(employeeRepo).save(employee);
//    }
}