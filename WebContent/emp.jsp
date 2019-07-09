<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="com.management.domain.Employee"%>
<%@ page import="com.management.dao.impl.EmployeeDaoImpl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EMPLOYEE MANAGEMENT</title>
</head>

<body>
	<center>
		<h1>
			<center>
				<u><b>EMPLOYEE MANAGEMENT</b></u>
			</center>
		</h1>
		<%-- <%
			EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
			List<Employee> employees = employeeDao.findAllEmployee();
			for (Employee b : employees) {
				System.out.println(b);
				request.setAttribute("employeeList", employees);
			}
		%>
 --%>
		<c:url value="/employee/add" var="addUrl" />
		<form action="${addUrl}" method="post">
			<table>
				<c:if test="${employee.id ne null}">
					<tr>
						<td>Employee ID:</td>
						<td><input type="text" name="id" value="${employee.id}"
							readonly="readonly"></td>
					</tr>
				</c:if>
				<tr>
					<td>First Name:</td>
					<td><input type="text" name="firstName"
						value="${employee.firstName}" required></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><input type="text" name="lastName"
						value="${employee.lastName}" required></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="email" name="email" value="${employee.email}"
						required></td>
				</tr>

				<c:if test="${employee.id ne null}">
					<tr>
						<td colspan="2"><input type="submit" value="Update"></td>
					</tr>
				</c:if>
				<c:if test="${employee.id eq null}">
					<tr><td></td>
						<td colspan="2"><input type="submit" value="Save"></td>
					</tr>
				</c:if>
			</table>
		</form>
		<br>
		<h1>List of Employees</h1>
		<table border="1">

			<thead>
				 
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Update</th>
					<th>Delete</th>
				 
			</thead>
			<c:forEach items="${employeeList}" var="employee">
				<tr>
					<td><c:out value="${employee.id}" /></td>
					<td><c:out value="${employee.firstName}" /></td>
					<td><c:out value="${employee.lastName}" /></td>
					<td><c:out value="${employee.email}" /></td>

					<td>
						<form action="<c:url value="/employee/update"/>" method="post">
							<input type="hidden" name="empId" value="${employee.id}">
							<input type="submit" value="Update">
						</form>
					<td>
						<form action="<c:url value="/employee/delete"/>" method="post">
							<input type="hidden" name="empId" value="${employee.id}">
							<input style="background: #F00;" type="submit" value="Delete">
						</form>
						 
					</td>
				</tr>
			</c:forEach>

		</table>
</body>
</html>