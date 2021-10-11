<%@ page import="Models.*, com.users.*, java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="true" %>  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
<style>
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

.card2 {
  border: none;
  outline: 0;
  padding: 12px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  font-size: 18px;
}
.img{
	height: 100px;
	width: 100px;
}

.card button:hover {
  opacity: 0.7;
}
.icon{
	height:24px;	
	width:24px;
}

.total{
	position:fixed;
	 bottom: 0;
  right: 0;
  width: 300px;
  border: 3px solid #000;
}
</style>
</head>
<body>
	<div>
		<nav><a href="productListing.jsp"> &lt;- Back to Listing Page.</a></nav>
	</div>
	
	<h1 style="text-align:center;">Cart</h1>
	<%! double total=0; %>
	<%
		String increment="increment";
		String decrement="decrement";
		String delete="delete";
		
		String incrementIcon="https://cdn-icons-png.flaticon.com/512/992/992651.png";
		String decrementIcon="https://cdn-icons-png.flaticon.com/512/66/66889.png";
		String deleteIcon="https://cdn-icons-png.flaticon.com/512/1214/1214428.png";
		
		ProductsDao productsDao=new ProductsDao();
		User user=(User) session.getAttribute("user");
		
		CartDao cartDao=new CartDao();
		ArrayList<Cart> cart=cartDao.getCart(user.username);
		
		if(cart.size() == 0){
			out.println("Your Cart is empty");
			out.println("Add Items to cart by clicking on Add to Cart.");
		}else{
			total=0;
			for(Cart cartItem : cart){
				Product product=productsDao.getProduct(cartItem.getProductId());
				
				total+=(product.price*cartItem.getQuantity());
	%>
		<div class="card">
		  <img class="img" src=<%= product.ImageUrl %> alt=<%= product.title %>>
		  <h1><%= product.title %></h1>
		  <p class="price"><%= product.price %></p>
		  <p><%= product.description %></p>
		  <p>Quantity: <%= cartItem.getQuantity() %></p>
		  <p>
		  	<a href="handler?id=<%= product.id %>&handle=<%= increment %>"><img class="icon" src=<%= incrementIcon %>></a> &nbsp;&nbsp;&nbsp;
			<a href="handler?id=<%= product.id %>&handle=<%= decrement %>"><img class="icon" src=<%= decrementIcon %>></a>&nbsp;&nbsp;&nbsp;
			<a href="handler?id=<%= product.id %>&handle=<%= delete %>"><img class="icon" src=<%= deleteIcon %>></a><br>
		  </p>
		</div>
		<br>
		<hr>
		<br>
	<%		}
		} 
	%>
	
	<div class="total">
		<h2>Total: <%=total %></h2>
	</div>
	
</body>
</html>