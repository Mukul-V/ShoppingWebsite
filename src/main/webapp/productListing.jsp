<%@ page import="Models.*,com.users.*, java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page session="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>40% Off...</title>
<style>
.parent{
	display: flex;
		
}
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  max-width: 300px;
  margin: auto;
  text-align: center;
  font-family: arial;
}

.price {
  color: grey;
  font-size: 22px;
}


.card .btn {
  border: none;
  outline: 0;
  padding: 12px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}
a {
  text-decoration: none !important;
}
.card .btn:hover {
  opacity: 0.7;
}
.qtyButtons a{
	font-size:40px;
	
}
a, a:visited, a:hover, a:active {
  color: inherit;
}
.allUsersLink{
border: none;
  outline: 0;
  padding: 12px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}
</style>
</head>
<body>
	  
	  <%!	  
	  String name="", password="", color="";
	  ArrayList<Product> products=null;
	  ArrayList<String> productIds=null;
	 

	  %>

	<%
	try{
		User user= (User) session.getAttribute("user");
		name=user.name;
		password=user.password;
		color=user.color;
		
		ProductsDao productsObj=new ProductsDao();
		products=productsObj.getAsList();
		
			}catch(Exception e){
		response.sendRedirect("/index.html");
			}
	%>
	
	<h1>Welcome <%= name %>,</h1>
	<hr/>
	<h3 style="color:<%=color%>;">As Your favorite color has unique quality, we got unique collection for you.</h3>
	<br/>
	<div class="allUsersLink"><a href="AllUsers.jsp">Show fellow Users</a></div>
	<div><a href="Cart.jsp">View Cart</a></div>
	
	<hr>
	<br/><br/>
	<div class="parent">
	<%
	for(Product p: products){
	%>
	<div class="card"> 
	<a class="disable" href="productDisplay.jsp?id=<%= p.id %>">
	    <img src="<%= p.ImageUrl %>" alt="<%= p.title %>" style="width:100px;height:100px;"/>
	  <h1><%= p.title %></h1>
	  <p class="price"> &#8377; <%= p.price %></p>
	  <p><%= p.description %></p>
	  </a>
		<div>
	<br>
	</div>
	  <p><button class="btn">Add to Cart</button></p>
	</div>
	<%
		}
	%>
	</div>
	
</body>
</html>

