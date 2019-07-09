package com.management.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.management.dao.EmployeeDao;
import com.management.dao.impl.EmployeeDaoImpl;

@WebServlet("/employee/delete")
public class DeleteController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	  public DeleteController() {
	    }
	 
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	 
	        String empId = request.getParameter("empId");
	 
	        if (empId == "" || empId == null)
	            request.getRequestDispatcher("/").forward(request, response);
	        else {
	            Long id = Long.parseLong(empId);
	            EmployeeDao employeeDao = EmployeeDaoImpl.getInstance();
	 
	            employeeDao.deleteEmployee(id);
	 
	            response.sendRedirect(request.getContextPath() + "/");
	        }
	    }
}
