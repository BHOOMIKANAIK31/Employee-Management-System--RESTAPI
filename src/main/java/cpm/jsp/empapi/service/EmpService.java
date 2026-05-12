package cpm.jsp.empapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cpm.jsp.empapi.entity.Employee;
import cpm.jsp.empapi.exception.DataExistsException;
import cpm.jsp.empapi.exception.DataNotFoundException;
import cpm.jsp.empapi.repository.Emprep;

@Service
public class EmpService {
@Autowired
	private Emprep rep;


public List<Employee> getEmployees(int page,int size,String sort,boolean desc) {
	PageRequest pageRequest=PageRequest.of(page-1, size,desc?Sort.by(sort).descending():Sort.by(sort).ascending());
	List<Employee> employee = rep.findAll(pageRequest).getContent();
    if (employee.isEmpty()) {
        throw new DataNotFoundException("No Employees Records Found");
    }
    return employee;
}
public Employee saveEmployee(Employee employee) {
    if (rep.existsByPhno(employee.getPhno())) {
        throw new DataExistsException("Phone Number Already Exists");
    }
    return rep.save(employee);
}
public Employee getEmployeesbyid(Integer id) {
	
	return rep.findById(id).orElseThrow(()->new DataNotFoundException(" NO EMPLOYEE WITH ID:"+id));
}
public List<Employee> getEmployeesbyname(String name) {
	List<Employee> emp=rep.findByNameIgnoreCase(name);
	if(emp.isEmpty())
		throw new DataNotFoundException("data not found with name:"+name);
	return emp;
}
public Employee getEmployeesbyphno(String mobile) {
    return rep.findByPhno(mobile)
        .orElseThrow(() -> 
            new DataNotFoundException("No employee found with phone: " + mobile));
}

public List<Employee> getEmployeesbydepartment(String department) {
	List<Employee>emp=rep.findByDepartment(department);
	if(emp.isEmpty())
		throw new DataNotFoundException("the record not found for department:"+department);
	return emp;
}
public void deleteEmployeesbyid(Integer id) {
	
	
	rep.findById(id).orElseThrow(()->new DataNotFoundException(" NO EMPLOYEE WITH ID:"+id));
	rep.deleteById(id);
}
public Employee putEmployee(Integer id,Employee emp) {
	rep.findById(id).orElseThrow(()->new DataNotFoundException(" NO EMPLOYEE WITH ID:"+id));
	emp.setId(id);
	
	return rep.save(emp);
	
	
}
public Employee patchEmployee(Integer id, Employee emp) {

	Employee exemp=rep.findById(id).orElseThrow(()->new DataNotFoundException(" NO EMPLOYEE WITH ID:"+id)); 
if(emp.getDepartment()!=null)
	exemp.setDepartment(emp.getDepartment());
	if(emp.getName()!=null)
		exemp.setName(emp.getName());
		if(emp.getSalary()!=null)
			exemp.setSalary(emp.getSalary());
			if(emp.getPhno()!=null)
				exemp.setPhno(emp.getPhno());
			return rep.save(exemp);
					
}





}