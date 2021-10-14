<%@ page import="Models.*, com.users.*, java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Orders</title>
</head>
<body>
	<div >
		<nav><a href="productListing.jsp"> &lt;- Back to Listing Page.</a></nav>
	</div>
	
	<h1 style="text-align:center;">Orders History</h1>
	
	<%
		ProductsDao products=new ProductsDao();
		User user=(User) session.getAttribute("user");
		OrdersDao ordersDao=new OrdersDao();
		ArrayList<String> orderIds=ordersDao.getOrderIds(user.username);
		
		if(orderIds.size() == 0){
			%>
			<h1>No Items Bought. Check out some new stuff.</h1>
			<a href="productListing.jsp">View All Products.</a>
			<%	
		}
		else{
			for(String orderId: orderIds){
				ArrayList<Order> orders=ordersDao.getOrders(user.username, orderId);
				
				OrderTotal orderTotal=ordersDao.getOrderTotal(user.username, orderId);
			%>			
				<h3>OrderID: <%= orderId %></h3>
			<%	
				
				for(Order order: orders){
					Product product=products.getProduct(order.productId);
		%>		
		<div>
			<h2>Name: <%= product.title %></h2>
			<p>Price: <%= product.price %>
			<p>Quantity: <%= order.quantity %></p>
		</div>
				<% } %>
			<h2>Total = &#8377;<%= orderTotal.total %></h2>
			<hr>
			<% } 
			
		}%>
</body>
</html>