package Models;

public interface Helper {
	final String Increment="increment";
	final String Decrement="decrement";
	
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
	final String ProductId="productId";
	final String Total="total";
	
	
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
	final String Handle="handle";
	
	final String User="user";
	final String Product="product";

	final String SignUpPage="signUp.html";
	final String LoginPage="login.html";

	final String ProductListingJSP="productListing.jsp";
	final String ProductDisplayJSP="productDisplay.jsp";
}
