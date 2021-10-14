package com.users;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

import Models.*;
public class OrdersDao implements Helper{

	DBConnection db=new DBConnection();
	
	public ArrayList<Order> getAllOrders(String username) throws ClassNotFoundException{
		ArrayList<Order> orderList=new ArrayList<>();
		Connection conn= db.createConnection();
		try {
			PreparedStatement st=conn.prepareStatement(GetOrders);
			st.setString(1, username);
			ResultSet rs= st.executeQuery();
		
			while(rs.next()) {
				Order order=new Order(rs.getString("orderId"), rs.getString("productId"), rs.getInt("quantity"));
				orderList.add(order);
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return orderList;
	}
	
	public ArrayList<Order> getOrders(String username, String orderId) throws ClassNotFoundException{
		ArrayList<Order> orderList=new ArrayList<>();
		Connection conn= db.createConnection();
		try {
			PreparedStatement st=conn.prepareStatement(GetOrdersUsingID);
			st.setString(1, username);
			st.setString(2, orderId);
			ResultSet rs= st.executeQuery();
		
			while(rs.next()) {
				Order order=new Order(rs.getString("orderId"), rs.getString("productId"), rs.getInt("quantity"));
				orderList.add(order);
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return orderList;
	}
	
	public ArrayList<String> getOrderIds(String username) throws ClassNotFoundException{
		ArrayList<String> orderIdList=new ArrayList<>();
		Connection conn= db.createConnection();
		try {
			PreparedStatement st=conn.prepareStatement(GetOrderIds);
			st.setString(1, username);
			ResultSet rs= st.executeQuery();
		
			while(rs.next()) {
				String orderId=rs.getString(OrderId);
				orderIdList.add(orderId);
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return orderIdList;
	}
	
	
	public OrderTotal getOrderTotal(String username, String orderId) throws ClassNotFoundException{
		OrderTotal orderTotal=null;
		Connection conn= db.createConnection();
		try {
			PreparedStatement st=conn.prepareStatement(GetOrderTotal);
			st.setString(1, username);
			st.setString(2, orderId);
			ResultSet rs= st.executeQuery();
		
			while(rs.next()) {
				orderTotal=new OrderTotal(rs.getString("orderId"), rs.getInt("total"));
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return orderTotal;
	}
	
	
	public boolean addOrder(String username, Order order) throws ClassNotFoundException {
		boolean result=false;
		Connection conn= db.createConnection();
		
		try {
			PreparedStatement st= conn.prepareStatement(AddOrder);
			st.setString(1, username);
			st.setString(2, order.orderId);
			st.setString(3, order.productId);
			st.setInt(4, order.quantity);
			int rs=st.executeUpdate();
			conn.close();
			if(rs > 0) {
				result=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	
	public boolean addOrderTotal(String username, OrderTotal orderTotal) throws ClassNotFoundException {
		boolean result=false;
		Connection conn= db.createConnection();
		
		try {
			PreparedStatement st= conn.prepareStatement(AddOrderTotal);
			st.setString(1, username);
			st.setString(2, orderTotal.orderId);
			st.setDouble(3, orderTotal.total);
			int rs=st.executeUpdate();
			conn.close();
			if(rs > 0) {
				result=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	

}
