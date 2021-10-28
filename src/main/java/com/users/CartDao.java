package com.users;
import Models.*;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.net.http.HttpResponse;


public class CartDao implements Helper{

	
	
	public static boolean addToCart(String username, String productId) {
		String url=API+Cart+AddToCart+username+"/"+productId;
		HttpResponse res=APICall.getRequest(url);		
		Gson g=new Gson();
		Result result=g.fromJson(res.body().toString(), Result.class);
		
		return result.isResult();
	}
	public static boolean removeFromCart(String username, String productId){
		String url=API+Cart+RemoveFromCart+username+"/"+productId;
		HttpResponse res=APICall.getRequest(url);		
		Gson g=new Gson();
		Result result=g.fromJson(res.body().toString(), Result.class);
		
		return result.isResult();
	}
	
	 public static boolean isPresentInCart(String username, String productId){
			String url=API+Cart+IsPresent+username+"/"+productId;
			HttpResponse res=APICall.getRequest(url);		
			Gson g=new Gson();
			Result result=g.fromJson(res.body().toString(), Result.class);
			
			return result.isResult();
	}
	
	public static int itemCount(String username, String productId){
		String url=API+Cart+ItemCount+username+"/"+productId;
		HttpResponse res=APICall.getRequest(url);		
		Gson g=new Gson();
		int itemCount=g.fromJson(res.body().toString(), Integer.class);
		
		return itemCount;	
	}

	
	public static int itemsCount(String username){
		int count=0;
		String url=API+Cart+ItemsCount+username;
		HttpResponse res=APICall.getRequest(url);		
		Gson g=new Gson();
		count=g.fromJson(res.body().toString(), Integer.class);
		
		return count;	

	}
	
		
	public static ArrayList<Cart> getCart(String username) {
		String url=API+Cart+GetCart+username;
		HttpResponse res=APICall.getRequest(url);
		Gson g = new Gson();
		ArrayList<Cart> cartItems=g.fromJson(res.body().toString(),new TypeToken<ArrayList<Cart>>(){}.getType());
		return cartItems;
	}

	public static Cart getCartItem(String username, String productId) {
		String url=API+Cart+GetCart+username+"/"+productId;
		HttpResponse res=APICall.getRequest(url);		
		Gson g=new Gson();
		Cart cartItem=g.fromJson(res.body().toString(), Cart.class);
		
		return cartItem;
	}
	
	public static boolean increaseQuantity(String username, String productId){

		String url=API+Cart+IncreaseQuantity+username+"/"+productId;
		HttpResponse res=APICall.getRequest(url);		
		Gson g=new Gson();
		Result result=g.fromJson(res.body().toString(), Result.class);
		
		return result.isResult();
	}
	
	public static boolean decreaseQuantity(String username, String productId){

		String url=API+Cart+DecreaseQuantity+username+"/"+productId;
		HttpResponse res=APICall.getRequest(url);		
		Gson g=new Gson();
		Result result=g.fromJson(res.body().toString(), Result.class);
		
		return result.isResult();
	}
	
}
