<%@page import="studentdatabase.dao.StudentDao"%>
<%@page import="studentdatabase.dto.Student"%>
<%@page import="java.util.List"%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<title>Home</title>
</head>
<body>
	
	<% String message1 = "hello"; %>    <!-- declaration tag --> 
	
	<h1> <%= message1 %> </h1>            <!-- expression tag -->
	<% String message = (String)request.getAttribute("name"); %>
	<h1>WELCOME</h1>
	<% if(message!=null){ %>
		<h2>-=-==-=-<%= message  %> =-=-=-=-=-</h2>
	<% } %>
	
	<table border = "2px" class="table table-bordered">
	<tr class="table-info">
		<th>Student_id</th>
		<th>Student_name</th>
		<th>Student_email</th>
		<th>Student_address</th>
		<th>Student_phone</th>
		<th>Student_school</th>
		<th>delete</th>
		<th>edit</th>
		

	</tr>
	
	<% 
	   StudentDao dao = new StudentDao();
	   List<Student> students = dao.getAllStudent();
	   for(Student s :students){
	%>
	<tr class="table-info">
		<td><%= s.getId()  %></td>
		<td><%= s.getName()  %></td>
		<td><%= s.getEmail() %></td>
		<td><%= s.getAddress() %></td>
		<td><%= s.getPhone()  %></td>
		<td><%= s.getSchool()  %></td>
		<td> <a href="delete?id=<%= s.getId() %>"> Delete </a></td>
		<td> <a href ="edit?id=<%= s.getId() %>"> edit</a></td>
	</tr>
	
	<%} %>

	</table>
	
	<a href ="logout"> logout</a>
	
</body>
</html>