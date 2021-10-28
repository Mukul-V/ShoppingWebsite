package com.users;
import java.net.http.HttpResponse;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Models.*;
public class OrdersDao implements Helper{

	
	public ArrayList<Order> getAllOrders(String username) throws ClassNotFoundException{
		String url=API+Orders+GetAllOrders+username;
		HttpResponse res=APICall.getRequest(url);
		Gson g = new Gson();
		ArrayList<Order> orderList=g.fromJson(res.body().toString(),new TypeToken<ArrayList<Order>>(){}.getType());
		return orderList;
	}
	
	public ArrayList<Order> getOrders(String username, String orderId) throws ClassNotFoundException{
		String url=API+Orders+GetOrders+username+"/"+orderId;
		HttpResponse res=APICall.getRequest(url);
		Gson g = new Gson();
		ArrayList<Order> orderList=g.fromJson(res.body().toString(),new TypeToken<ArrayList<Order>>(){}.getType());
		return orderList;
	}
	
	public ArrayList<String> getOrderIds(String username) throws ClassNotFoundException{
		String url=API+Orders+GetOrderIds+username;
		HttpResponse res=APICall.getRequest(url);
		Gson g = new Gson();
		ArrayList<String> orderIdList=g.fromJson(res.body().toString(),new TypeToken<ArrayList<String>>(){}.getType());
		return orderIdList;
	}
	
	
	public OrderTotal getOrderTotal(String username, String orderId) throws ClassNotFoundException{
		String url=API+Orders+GetOrderTotal+username+"/"+orderId;
		HttpResponse res=APICall.getRequest(url);
		Gson g = new Gson();
		OrderTotal orderTotal=g.fromJson(res.body().toString(), OrderTotal.class);
		return orderTotal;
	}
	
	
	public boolean addOrder(String username, Order order)  {
		String url=API+Orders+AddOrder+username;
		String orderJson=new Gson().toJson(order);
		HttpResponse res= APICall.postRequest(url, orderJson);
		
		//.
		Gson g=new Gson();
		Result result=new Result();
		result=g.fromJson(res.body().toString(), Result.class);
		return result.isResult();
	}
	
	
	
	public boolean addOrderTotal(String username, OrderTotal orderTotal) {
		String url=API+Orders+AddOrderTotal+username;
		String orderTotalJson=new Gson().toJson(orderTotal);
		
		HttpResponse res= APICall.postRequest(url, orderTotalJson);
		Gson g=new Gson();
		Result result=new Result();
		result=g.fromJson(res.body().toString(), Result.class);
		return result.isResult();

	}
}
