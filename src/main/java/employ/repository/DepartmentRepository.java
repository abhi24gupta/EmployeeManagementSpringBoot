package employ.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import employ.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{
    public static final String HASH_KEY="depkey";

}
