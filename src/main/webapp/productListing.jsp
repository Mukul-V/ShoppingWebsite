<%@ page import="Models.*,com.users.*, java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page session="true"%>

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

.card .removeBtn {
  border: 2px solid black;
  outline: 0;
  padding: 12px;
  color: black;
  background-color: #fff;
  text-align: center;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
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

.nav{
	display:flex;
	flex-direction: horizontal;
	justify-content: space-between;
}

</style>
</head>
<body>
	  
	  <%!
	  String name="", password="", color="";
	  String addToCart="addToCart";
	  String removeFromCart="removeFromCart";
	  ArrayList<Product> products=null;
	  ArrayList<String> productIds=null;

	  %>

	<%
	
	CartDao cartDao=new CartDao();
	
	User user=null;
	try{
		user= (User) session.getAttribute("user");
		name=user.name;
		password=user.password;
		color=user.color;
		
		ProductsDao productsObj=new ProductsDao();
		products=productsObj.getAsList();
		
		
			}catch(Exception e){
		response.sendRedirect("/index.html");
			}
	%>
	<div class="nav">
		<h1>Welcome <%= name %>,</h1>
		<a class="viewCart" href="Cart.jsp">View Cart</a>
		<a class="viewCart" href="orders.jsp">Orders</a>
	</div>
	<hr/>
	<h3 style="color:<%=color%>;">As Your favorite color has unique quality, we got unique collection for you.</h3>
	<br/>
	<hr>
	<br/><br/>
	<div class="parent">
	<%
	for(Product product: products){
	%>
	<div class="card"> 
	<a class="disable" href="productDisplay.jsp?id=<%= product.id %>">
	    <img src="<%= product.imageUrl %>" alt="<%= product.title %>" style="width:100px;height:100px;"/>
	  <h1><%= product.title %></h1>
	  <p class="price"> &#8377; <%= product.price %></p>
	  <p><%= product.description %></p>
	  </a>
		<div>
	<br>
	</div>
	
		<% if(!cartDao.isPresentInCart(user.username, product.id)){ %>
		  	<a class="btn" href="cartHandler?id=<%= product.id %>&handle=<%= addToCart %>">Add to Cart</a> &nbsp;&nbsp;&nbsp;
		  <%}else{ %>
		 	 <a class="removeBtn" href="cartHandler?id=<%= product.id %>&handle=<%= removeFromCart %>">Remove From Cart</a> &nbsp;&nbsp;&nbsp;
		  <%} %>
		
	</div>
	<%
		}
	%>
	</div>
	
</body>
</html>

