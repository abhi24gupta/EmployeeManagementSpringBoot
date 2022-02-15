package employ.service;

import employ.entity.Salary;
import employ.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryService {

    @Autowired
    public SalaryRepository salaryRepository;

    public List<Salary> findAllSalary() {
        return salaryRepository.findAll();
    }


    public String addSalary(Salary salary) {
        salaryRepository.save(salary);
        return "DATA of the Salary added";
    }

    public SalaryService(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }
}
