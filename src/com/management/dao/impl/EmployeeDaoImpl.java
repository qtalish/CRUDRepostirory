package com.management.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.management.dao.EmployeeDao;
import com.management.db.Database;
import com.management.domain.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private static EmployeeDaoImpl employeeDaoImpl = null;

	private Connection connection = Database.getConnection();

	public long saveEmployee(Employee employee) {
		System.out.println("EmployeeDaoImpl.saveEmployee()");
		String sql = "INSERT INTO employee_manager(first_name, last_name, email) VALUES(?,?,?)";
		long id = 0;
		try {
			PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
 
			ps.setString(1, employee.getFirstName());
			ps.setString(2, employee.getLastName());
			ps.setString(3, employee.getEmail());
         
            if (ps.executeUpdate() > 0) {
                
                ResultSet rs = ps.getGeneratedKeys();
                                                              
                if (rs.next())
                    id = rs.getLong(1);
            }
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
		return id;

	}
	public void updateEmployee(Employee employee) {
        String sql = "UPDATE employee_manager SET"
                    +" first_name=?, last_name=?, email=?"
                    + "WHERE employee_id=?";
 
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getEmail());
            ps.setLong(4, employee.getId());
 
            ps.executeUpdate();
 
        } catch (Exception ex) {
        	ex.printStackTrace();
            //System.out.println(ex.getMessage());
        }
    }
 
    public void deleteEmployee(Long id) {
        String sql = "DELETE FROM employee_manager WHERE employee_id=?";
 
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);

            ps.executeUpdate();
 
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public Employee findEmployeeById(Long id) {
        String sql = "SELECT * FROM employee_manager WHERE employee_id=?";
 
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
 
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getLong(1));
                employee.setFirstName(resultSet.getString(2));
                employee.setLastName(resultSet.getString(3));
                employee.setEmail(resultSet.getString(4));
          
 
                return employee;
            }
 
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
 
        return null;
    }
    public List<Employee> findAllEmployee() {
              List<Employee> employees = new ArrayList<Employee>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM employee_manager");

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                if (employees == null)
                    employees = new ArrayList<>();
 
                Employee employee = new Employee();
                employee.setId(resultSet.getLong(1));
                employee.setFirstName(resultSet.getString(2));
                employee.setLastName(resultSet.getString(3));
                employee.setEmail(resultSet.getString(4));
 
                employees.add(employee);
            }
 
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
 
        return employees;
    }
	public static EmployeeDao getInstance() {
		if (employeeDaoImpl == null)
			employeeDaoImpl = new EmployeeDaoImpl();

		return employeeDaoImpl;
	}
}
