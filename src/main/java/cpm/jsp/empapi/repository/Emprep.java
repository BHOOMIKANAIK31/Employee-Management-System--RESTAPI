package cpm.jsp.empapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cpm.jsp.empapi.entity.Employee;



public interface Emprep extends JpaRepository<Employee,Integer>{
	

	

	List<Employee> findByNameIgnoreCase(String name);







	



	List<Employee> findByDepartment(String dept);



	Optional<Employee> findByPhno(String phno);



	boolean existsByPhno(String string);

}
