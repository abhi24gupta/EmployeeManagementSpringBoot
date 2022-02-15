package employ.service;

import employ.entity.Salary;
import employ.repository.SalaryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SalaryServiceTest {

    @Mock
    private SalaryRepository salaryRepo;

    private SalaryService salaryService;

    @Mock
    private Salary salary;

    @BeforeEach
    void setUp() {
        salaryService= new SalaryService(salaryRepo);
    }

    @Test
    void findAllSalary() {
        salaryService.findAllSalary();
        verify(salaryRepo).findAll();
    }

    @Test
    void addSalary() {
        salaryService.addSalary(salary);
        verify(salaryRepo).save(salary);

    }
}