package cpm.jsp.empapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cpm.jsp.empapi.dto.EmployeeDTO;
import cpm.jsp.empapi.entity.Employee;
import cpm.jsp.empapi.mapper.EmployeeMapper;
import cpm.jsp.empapi.service.EmpService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/employees")
public class EmpController {

    @Autowired
    private EmpService service;

    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDTO> getEmployees(
            @RequestParam(defaultValue="1") int page,
            @RequestParam(defaultValue="10") int size,
            @RequestParam(defaultValue="id") String sort,
            @RequestParam(defaultValue="false") boolean desc) {

        return service.getEmployees(page, size, sort, desc)
                .stream()
                .map(EmployeeMapper::toDTO)
                .toList();
    }

    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDTO saveEmployee(@Valid @RequestBody EmployeeDTO dto) {

        Employee saved = service.saveEmployee(
                EmployeeMapper.toEntity(dto)
        );

        return EmployeeMapper.toDTO(saved);
    }

    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDTO findEmployeebyid(@PathVariable Integer id) {

        return EmployeeMapper.toDTO(
                service.getEmployeesbyid(id)
        );
    }

  
    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDTO> findEmployeebyname(@PathVariable String name) {

        return service.getEmployeesbyname(name)
                .stream()
                .map(EmployeeMapper::toDTO)
                .toList();
    }

    
    @GetMapping("/phno/{phno}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDTO findEmployeebyphno(@PathVariable String phno) {

        return EmployeeMapper.toDTO(
                service.getEmployeesbyphno(phno)
        );
    }

    
    @GetMapping("/department/{dept}")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDTO> findEmployeebydepartment(@PathVariable String dept) {

        return service.getEmployeesbydepartment(dept)
                .stream()
                .map(EmployeeMapper::toDTO)
                .toList();
    }

    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployeebyid(@PathVariable Integer id) {
        service.deleteEmployeesbyid(id);
    }

    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDTO putEmployee(@PathVariable Integer id,
                                  @Valid @RequestBody EmployeeDTO dto) {

        Employee updated = service.putEmployee(
                id,
                EmployeeMapper.toEntity(dto)
        );

        return EmployeeMapper.toDTO(updated);
    }

    
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDTO patchEmployee(@PathVariable Integer id,
                                     @RequestBody EmployeeDTO dto) {

        Employee updated = service.patchEmployee(
                id,
                EmployeeMapper.toEntity(dto)
        );

        return EmployeeMapper.toDTO(updated);
    }
}