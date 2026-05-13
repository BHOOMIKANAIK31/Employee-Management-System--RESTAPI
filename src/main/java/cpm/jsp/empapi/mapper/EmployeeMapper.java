package cpm.jsp.empapi.mapper;

import cpm.jsp.empapi.entity.Employee;
import cpm.jsp.empapi.dto.EmployeeDTO;

public class EmployeeMapper {
	 public static Employee toEntity(EmployeeDTO dto) {
	        if (dto == null) return null;

	        Employee emp = new Employee();
	        emp.setId(dto.getId());
	        emp.setName(dto.getName());
	        emp.setSalary(dto.getSalary());
	        emp.setDepartment(dto.getDepartment());
	        emp.setPhno(dto.getPhno());

	        return emp;
	    }

	    public static EmployeeDTO toDTO(Employee emp) {
	        if (emp == null) return null;

	        EmployeeDTO dto = new EmployeeDTO();
	        dto.setId(emp.getId());
	        dto.setName(emp.getName());
	        dto.setSalary(emp.getSalary());
	        dto.setDepartment(emp.getDepartment());
	        dto.setPhno(emp.getPhno());

	        return dto;
	    }
}
