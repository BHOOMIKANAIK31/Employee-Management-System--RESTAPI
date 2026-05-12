package cpm.jsp.empapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cpm.jsp.empapi.entity.Employee;
import cpm.jsp.empapi.service.EmpService;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/v1/employees")
public class EmpController {

	@Autowired
	private EmpService service;
	
	@GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployees(@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="10")int size,@RequestParam(defaultValue="id")String sort,@RequestParam(defaultValue="false")boolean desc) {
        return service.getEmployees(page,size,sort,desc);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee saveEmployee(@Valid @RequestBody Employee employee) {
        return service.saveEmployee(employee);
    }
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee findEmployeebyid(@PathVariable Integer id ) {
        return service.getEmployeesbyid(id);
    }
    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> findEmployeebyname(@PathVariable String name ) {
        return service.getEmployeesbyname(name);
    }
    
    @GetMapping("/phno/{phno}")
    @ResponseStatus(HttpStatus.OK)
    public Employee findEmployeebyphno(@PathVariable String phno ) {
        return service.getEmployeesbyphno(phno);
    }
    
    @GetMapping("/department/{dept}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> findEmployeebydepartment(@PathVariable String dept ) {
        return service.getEmployeesbydepartment(dept);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployeebyid(@PathVariable Integer id ) {
        service.deleteEmployeesbyid(id);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee putEmployee(@PathVariable Integer id,@Valid @RequestBody Employee emp ) {
        return service.putEmployee(id,emp);
    }
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee patchEmployee(@PathVariable Integer id, @RequestBody Employee emp ) {
        return service.patchEmployee(id,emp);
    }
	}

