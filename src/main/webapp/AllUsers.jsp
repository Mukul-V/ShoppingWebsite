<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,  java.util.ArrayList, com.users.*, Models.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Users</title>
<style>
table, th, td {
  margin-left:40%;
  border: 1px solid black;
  border-collapse: collapse;
  font-size: 30px;
}

</style>
</head>
<body>
	<table style="border: 1px solid black;">
	<caption>Users</caption>
	<tr><th>Name</th><th>Username</th><th>Color</th></tr>
	<%!	ArrayList<User> allUsers=new ArrayList<>(); %>
	<% 
	
	try {
		
		UserDao userDao=new UserDao();
		allUsers=userDao.getAllUsers();
	} catch (Exception e) {
		e.printStackTrace();
	}
	for(int i=0;i<allUsers.size();i++){
	
	%>
	<tr><td><%= allUsers.get(i).name %></td><td><%= allUsers.get(i).username %></td>
	<td><%= allUsers.get(i).color %></td></tr>
	<% } %>	
	

	
	</table>

</body>
</html>