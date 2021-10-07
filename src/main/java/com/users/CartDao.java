package com.users;
import Models.*;
import java.util.*;
import java.sql.*;

public class CartDao implements Helper{

	static DBConnection db=new DBConnection();
	
	public static int itemCount(String username, String productId) throws SQLException, ClassNotFoundException {
		int count=0;
		Connection conn=db.createConnection();
		String fetchCartItemCount= GetCartItemCount;
		try {
			PreparedStatement st=conn.prepareStatement(fetchCartItemCount);
			st.setString(1, username);
			st.setString(2, productId);
			ResultSet rs=st.executeQuery();
			
			while(rs.next()) {
				count=rs.getInt("quantity");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		conn.close();
		return count;
		
	}

	
	public static int itemsCount(String username) throws ClassNotFoundException, SQLException {
		int count=0;
		Connection conn=db.createConnection();
		String fetchCartItemsCount= GetCartItemsCount;
		try {
			PreparedStatement st=conn.prepareStatement(fetchCartItemsCount);
			st.setString(1, username);
			ResultSet rs=st.executeQuery();
			
			while(rs.next()) {
				count=rs.getInt(Total);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		conn.close();
		return count;

	}
	
		
	public static ArrayList<Cart> getCart(String username) throws ClassNotFoundException, SQLException{
		ArrayList<Cart> cartItems=new ArrayList<>();
		Connection conn=db.createConnection();
		String fetchCart= GetCart;
		try {
			PreparedStatement st=conn.prepareStatement(fetchCart);
			st.setString(1, username);
			ResultSet rs=st.executeQuery();
			
			while(rs.next()) {
				Cart cart=new Cart(rs.getString(Username), rs.getString(ProductId), Integer.parseInt(rs.getString(Quantity)));
				cartItems.add(cart);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		conn.close();
		return cartItems;
	}

	public static Cart getCartItem(String username, String productId) throws SQLException, ClassNotFoundException {
		Cart cartItem=null;
		Connection conn=db.createConnection();
		String fetchCartItem= GetCartItem;
		try {
			PreparedStatement st=conn.prepareStatement(fetchCartItem);
			st.setString(1, username);
			st.setString(2, productId);
			ResultSet rs=st.executeQuery();
			
			while(rs.next()) {
				cartItem=new Cart(rs.getString(Username), rs.getString(ProductId), Integer.parseInt(rs.getString(Quantity)));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		conn.close();
		return cartItem;
	}
	
	public static boolean changeQuantity(String username, String productId, int quantity) throws ClassNotFoundException, SQLException{
		boolean result=false;
		Connection conn=db.createConnection();
		String fetchCart= QuantityStatement;
		try {
			PreparedStatement st=conn.prepareStatement(fetchCart);
			st.setInt(1, quantity);
			st.setString(2, username);
			st.setString(3, productId);
			int rs= st.executeUpdate();
			
			if(rs>0) {
				result=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		conn.close();
		return result;
	}
	
}
