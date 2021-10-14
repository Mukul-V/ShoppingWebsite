<%@ page import="Models.*, com.users.*, java.util.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buy Now!</title>
<style>
.container{
	text-align:center;	
}
a{
text-decoration:none;
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
		final String increment="increment";
		final String decrement="decrement";
	
		Product product=null;
		ArrayList<Cart> cartItems=null;
		int count=0;
		User user=null;
		final String staticText="One of the best deals for you,";
		
	%>
	<%
	user=(User) session.getAttribute("user");
			
			final String id=request.getParameter("id");
			ProductsDao products= new ProductsDao();
			product=products.getProduct(id);
			
			CartDao cartDao=new CartDao();
			count=cartDao.itemCount(user.username, id);
			
			if(product != null){
	%>
	
	<div >
		<nav><a href="productListing.jsp"> &lt;- Back to Listing Page.</a></nav>
	</div>
	
	<h1 style='text-align:center;'><%= staticText %> <%= user.name %> !</h1>
	
	
	<div style="margin-left:40%;">
	<img src="<%= product.ImageUrl %>" width="200px" height="200px" alt=<%= product.title %>/>
	<br>
	<h2 style="color:<%= user.color %>">Name: <%= product.title %></h2>
	<br>
	<h3 style="color:<%= user.color %>">Price: <%= product.price %></h3>
	<br>
	<h3>Quantity: <%= count %></h3>
	<br>
		<span>
			<a href="handler?id=<%= product.id %>&handle=<%= increment %>">+</a> &nbsp;&nbsp;&nbsp;
			<a href="handler?id=<%= product.id %>&handle=<%= decrement %>">-</a><br>
		</span>
	<br>
	<hr>
	<h3 style="color:<%= user.color %>">Description: <%= product.description %></h3>	
	
	</div>
		<% 
		}
		%>
</body>
</html>

