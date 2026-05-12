package cpm.jsp.empapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;
@NotBlank(message="name is required")
private String name;
@NotNull(message="salary is required")
@Positive(message="salary must be greater than 0")
private Double salary;
@NotBlank(message="department is required")
private String department;
@NotBlank(message="phno is required")
@Pattern(regexp = "^\\d{10}$",message="phone number must be exact 10 digits")
private String phno;
}
