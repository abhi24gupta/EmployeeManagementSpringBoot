package employ.controller;

import employ.entity.Salary;
import employ.repository.SalaryRepository;
import employ.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @GetMapping("/api/salary")
    public List<Salary> findAllSalary(@RequestBody Salary salary){
        return salaryService.findAllSalary(salary);
    }

    @PostMapping("/api/salary")
    public String addSalary(@RequestBody Salary salary){
        return salaryService.addSalary(salary);
    }




}
