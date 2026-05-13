package cpm.jsp.empapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class EmployeeDTO {
	private Integer id;

    @NotBlank(message = "name is required")
    private String name;

    @NotNull(message = "salary is required")
    @Positive(message = "salary must be greater than 0")
    private Double salary;

    @NotBlank(message = "department is required")
    private String department;

    @NotBlank(message = "phno is required")
    @Pattern(regexp = "^\\d{10}$", message = "phone number must be exact 10 digits")
    private String phno;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}
    
    
}
