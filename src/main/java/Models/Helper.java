package Models;

public interface Helper {
	final String Increment="increment";
	final String Decrement="decrement";
	final String Delete="delete";
	
	final String GetAllProducts="select * from products";
	final String GetProduct="select * from products where id=?";
	
	final String GetAllUsers="select * from users";
	final String SignUpStatement="insert into users values(? ,?, ?, ?)";
	final String GetUser="select * from users where username=? and password=?";
	
	final String GetCart="select users.username, cart.productId, cart.quantity from users join cart on users.username=cart.username"
			+ " where users.username=?";
	final String GetCartItem="select * from cart where username=? and productId=?";
	final String GetCartItemsCount=" select count(*) as total from cart where username=?";
	final String GetCartItemCount="select quantity from cart where username=? and productId=?";
	final String QuantityStatement="update cart set quantity=? where username=? and productId=?";
	final String AddToCart="insert into cart values(?, ?, ?);";
	final String RemoveFromCart="delete from cart where username=? and productId=?";
	
	final String ProductId="productId";
	final String Total="total";
	final String CartHandle="cartHandle";
	final String AddToCartHandler="addToCart";
	final String RemoveFromHandler="removeFromCart";
	final String CartJSP="Cart.jsp";
	final String OrderNow="orderNow";
	final String Handle="handle";
	
	final String AddOrder="insert into orders values(?, ?, ?, ?)";
	final String AddOrderTotal="insert into orderTotal values(?, ?, ?)";
	final String GetOrders="select * from orders  where username=?";
	final String GetOrdersUsingID="select * from orders  where username=? and orderId=?";
	final String GetOrderIds="select distinct orderId from orders where username=?";
	final String GetOrderTotal="select * from orderTotal where username=? and orderId=?";
	final String Products="products";
	final String OrderId="orderId";
	final String Timestamp="timestamp";
	
	
	final String Name="name";
	final String Username="username";
	final String Password="password";
	final String Color="color";
	
	final String Title="title";
	final String ImageUrl="imageUrl";
	final String Price="price";
	final String Description="description";
	final String Quantity="quantity";
	final String Id="id";


	
	final String User="user";
	final String Product="product";

	final String SignUpPage="signUp.html";
	final String LoginPage="login.html";

	final String OrdersJSP="orders.jsp";
	final String ProductListingJSP="productListing.jsp";
	final String ProductDisplayJSP="productDisplay.jsp";
}
