package employ.entity;

import java.util.Optional;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Employee_TBL")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String fname;
	private String lname;
	private char gender;
	private int age;
	private String address;
	private String emp_email;
	private String designation;
	

	@Autowired
	@ManyToOne
	private Department department;
}
