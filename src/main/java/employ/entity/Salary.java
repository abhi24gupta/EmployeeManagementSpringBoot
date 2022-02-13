package employ.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="salary_tbl")
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int salary_id;
    private int amount;
    private int deduction;
    private int bonus;

    @Autowired
    @OneToOne
    private Employee employee;



}
