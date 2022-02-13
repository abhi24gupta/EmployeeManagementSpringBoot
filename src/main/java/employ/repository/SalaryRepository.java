package employ.repository;

import employ.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary,Integer> {
}
