<%@ page import="Models.*, com.users.*, java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="true" %>  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
</head>
<body>
	<h1>Hello</h1>
	<%
		User user=(User) session.getAttribute("user");
		CartDao cartDao=new CartDao();
		ArrayList<Cart> cart=cartDao.getCart(user.username);
		
		if(cart.size() == 0){
			out.println("Your Cart is empty");
			out.println("Add Items to cart by clicking on Add to Cart.");
		}else{
			for(Cart cartItem : cart){

	%>
	
	<%		}
		} 
	%>
	
</body>
</html>