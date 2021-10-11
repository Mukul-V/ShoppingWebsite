package com.users;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

import Models.*;
public class OrdersDao implements Helper{

	DBConnection db=new DBConnection();
	
	public ArrayList<Product> getProducts(String username) throws ClassNotFoundException{
		ArrayList<Product> productList=new ArrayList<>();
		ProductsDao productsDao=new ProductsDao();
		Connection conn= db.createConnection();
		 
		try {
			PreparedStatement st=conn.prepareStatement(GetOrders);
			st.setString(1, "username");
			ResultSet rs= st.executeQuery();
		
			while(rs.next()) {
				String products=rs.getString(Products);
				String orderId=rs.getString(OrderId);
				String timestamp=rs.getString(Timestamp);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return productList;
	}
	
	

}
