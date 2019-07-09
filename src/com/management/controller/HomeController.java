
  package com.management.controller; import java.io.IOException; import
  java.util.List;
  
  import javax.servlet.ServletException; import
  javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest; import
  javax.servlet.http.HttpServletResponse;
  
  import com.management.dao.EmployeeDao; import
  com.management.dao.impl.EmployeeDaoImpl; import
  com.management.domain.Employee;
  
  
  @WebServlet("/home") public class HomeController extends HttpServlet { private
  static final long serialVersionUID = 1L;
  
  EmployeeDao employeeDao = new EmployeeDaoImpl();
  
  public HomeController() {
  
  }
  
  protected void doGet(HttpServletRequest request, HttpServletResponse
  response) throws ServletException, IOException {
  
  List<Employee> employees = employeeDao.findAllEmployee();
 
  request.setAttribute("employeeList", employees);
  
  request.getRequestDispatcher("/").forward(request, response); 
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse
  response) throws ServletException, IOException { doGet(request, response); }
  }
 