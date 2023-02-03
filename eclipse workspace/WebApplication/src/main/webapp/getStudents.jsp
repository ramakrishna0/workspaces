<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.src.dao.*"%>
<%@ page import="com.src.model.Employee"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border = "1px" style = "background-color: #FFFFE0; margin-left: auto; margin-right: auto " >
<tr>
	<th>ID</th>
	<th>Name</th>
	<th>Age</th>
	<th>Mobile</th>
	<th><a href="register.jsp">Add</a></th>
</tr>
<%
EmployeeDao dao = new EmployeeDaoImpl();
dao.getConnection();
List<Employee> employees = dao.getEmployees();

for (Employee e: employees) {
	
%>
<tr>
	<td><%= e.getId() %></td>
	<td><%= e.getName() %></td>
	<td><%= e.getAge() %></td>
	<td><%= e.getMobile() %></td>
	<td>Edit</td>
	<td><a href="./delete?eid= <%= e.getId() %>">Delete</a></td>
</tr>	
<%
}
%>

</table>
</body>
</html>