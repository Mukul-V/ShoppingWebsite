package com.users;

import com.google.gson.Gson;

import java.net.http.HttpResponse;

import Models.APICall;
import Models.Helper;
import Models.Result;
import Models.SignIn;
import Models.User;

public class UserDao implements Helper{
	
	public User signIn(String username, String password) {
		SignIn signInModel=new SignIn(username, password);
		String url=API+Users+Login;
		String signInJson=new Gson().toJson(signInModel);
		HttpResponse res= APICall.postRequest(url, signInJson);
		
		//.
		Gson g=new Gson();
		User user=g.fromJson(res.body().toString(), User.class);
		return user;
	}
	
	public boolean signUp(User user) {
		Gson g=new Gson();
		String url=API+Users+SignUp;
		
		String userJson=new Gson().toJson(user);
		HttpResponse res=APICall.postRequest(url, userJson);
		
		Result result=g.fromJson(res.body().toString(), Result.class);
		
		return result.isResult();
	}

}
