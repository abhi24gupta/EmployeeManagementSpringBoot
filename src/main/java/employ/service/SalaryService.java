package employ.service;

import employ.entity.Salary;
import employ.exception.ResouceNotFoundException;
import employ.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryService {

    @Autowired
    public SalaryRepository salaryRepository;

    public Salary salary;

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

    public Salary findSalaryById(int id) {
        return salaryRepository.findById(id).orElseThrow(() -> new ResouceNotFoundException("No Data found"));
    }

    public String deleteSalaryById(int id) {
        if(salaryRepository.existsById(id)){
            salaryRepository.deleteById(id);
            return "Salary Data deleted by given ID :  " + id;
        }
        else {
            return "Salary Data with ID :  " + id + "  is Not present";
        }
    }

    public Salary updateSalary(Salary salary, int id) {
        Salary existingSalary = salaryRepository.findById(id).orElseThrow(() -> new ResouceNotFoundException("No Salary found in DB"));
        existingSalary.setAmount(salary.getAmount());
        existingSalary.setBonus(salary.getBonus());
        existingSalary.setDeduction(salary.getDeduction());
        existingSalary.setEmployee(salary.getEmployee());
        return salaryRepository.save(existingSalary);
    }
}
