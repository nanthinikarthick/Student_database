
<%@page import="studentdatabase.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<% Student stu = (Student)request.getAttribute("student"); %>
	
	 <h1> <%= stu.getName() %> </h1> 
	 
	 <form action="update">
	id <input type = "text" name="id" value=<%= stu.getId() %> readonly="readonly"><br><br>
	name <input type = "text" name="name" value=<%= stu.getName() %>><br><br>
	phone <input type = "text" name="phone" value=<%= stu.getPhone() %>><br><br>
	school <input type = "text" name="school" value=<%= stu.getSchool() %>><br><br>
	mail <input type = "text" name="mail" value=<%= stu.getEmail() %>><br><br>
	address <input type = "text" name="address" value=<%= stu.getAddress() %>><br><br>
	password <input type = "password" name="password" value=<%= stu.getPassword() %>><br><br>
	 <input type="submit" value="update">
	 
	 </form>
	
	
</body>
</html>