package com.management.dao;

import java.util.List;
import com.management.domain.Employee;

public interface EmployeeDao {
	long saveEmployee(Employee employee);

	 void updateEmployee(Employee employee);
	 
	    void deleteEmployee(Long id);
	    
	    Employee findEmployeeById(Long id);
	    
	    List<Employee> findAllEmployee();
	}
	   
	 
	

