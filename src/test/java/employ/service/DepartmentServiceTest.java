package employ.service;

import employ.entity.Department;
import employ.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @Mock
    private DepartmentRepository departmentRepo;

    @Mock
    private Department department;

    private DepartmentService departmentService;

    @BeforeEach
    void setUp() {
        departmentService =new DepartmentService(departmentRepo);
    }

    @Test
    void addDepartment() {
        departmentService.addDepartment(department);
        verify(departmentRepo).save(department);
    }

    @Test
    void getDepartments() {
        departmentService.getDepartments();
        verify(departmentRepo).findAll();
    }

    @Test
    void getDepartment() {
        departmentService.getDepartment(department.getDepId());
        verify(departmentRepo).findById(department.getDepId());
    }

    @Test
    void updateDepartment() {
        departmentService.updateDepartment(department);
        verify(departmentRepo).save(department);
    }
}