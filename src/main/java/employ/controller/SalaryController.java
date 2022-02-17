package employ.controller;

import employ.entity.Salary;
import employ.repository.SalaryRepository;
import employ.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @PostMapping("/api/salary")
    public String addSalary(@RequestBody Salary salary){
        return salaryService.addSalary(salary);
    }

    @GetMapping("/api/salary")
    public List<Salary> findAllSalary(@RequestBody Salary salary){
        return salaryService.findAllSalary();
    }

    @GetMapping("/api/salary/{id}")
    public Salary findSalaryById(@PathVariable int id){
        return salaryService.findSalaryById(id);
    }

    @DeleteMapping("/api/salary/{id}")
    public String deleteSalaryById(@PathVariable int id){
        return salaryService.deleteSalaryById(id);
    }

    @PutMapping("/api/salary/{id}")
    public Salary updateSalary(@RequestBody Salary salary, @PathVariable int id){
        return salaryService.updateSalary(salary, id);



    }






}
