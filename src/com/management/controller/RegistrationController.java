package com.management.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.management.dao.EmployeeDao;
import com.management.dao.impl.EmployeeDaoImpl;
import com.management.domain.Employee;


@WebServlet("/employee/add")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
    private EmployeeDao employeeDao = EmployeeDaoImpl.getInstance();

	public RegistrationController() {
		super();
	}  
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		doPost(request, response);
        request.getRequestDispatcher("/").forward(request, response);
    }
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	  System.out.println("done");
            String empId = request.getParameter("id");
	        String firstName = request.getParameter("firstName");
	        String lastName = request.getParameter("lastName");
	        String email = request.getParameter("email");
    
	        Employee employee = new Employee();
	        employee.setFirstName(firstName);
	        employee.setLastName(lastName);
	        employee.setEmail(email);
	        if (empId == null || empId == "")
	            employeeDao.saveEmployee(employee);
	        else {
	            Long id = Long.parseLong(empId);
	            employee.setId(id);
	            employeeDao.updateEmployee(employee);
	        }
	
	        response.sendRedirect(request.getContextPath() + "/");
	    }
	        
	    }
	 
