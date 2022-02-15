package employ.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import employ.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    public static final String HASH_KEY="empkey";

}
