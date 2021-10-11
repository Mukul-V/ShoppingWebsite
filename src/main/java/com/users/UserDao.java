package com.users;
import java.util.*;
import java.sql.*;

import Models.Helper;
import Models.User;

public class UserDao implements Helper{
	static DBConnection db=new DBConnection();
	
	public User signIn(String username, String password) {
		try {
			Connection conn=db.createConnection();
			String fetchUser=GetUser;
			
			PreparedStatement st=conn.prepareStatement(fetchUser);
			st.setString(1,username);
			st.setString(2,password);
			ResultSet rs=st.executeQuery();			
			
			if(rs.next()) {
				return new User(rs.getString(Name), rs.getString(Username), rs.getString(Password), rs.getString(Color));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean signUp(User user) {
		try {
			Connection conn=db.createConnection();
			String insertUser=SignUpStatement;
			
			PreparedStatement st=conn.prepareStatement(insertUser);
			st.setString(1, user.name);
			st.setString(2, user.username);
			st.setString(3, user.password);
			st.setString(4, user.color);
			int rs=st.executeUpdate();
			
			conn.close();
			if(rs>0) {
				return true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static ArrayList<User> getAllUsers(){
		ArrayList<User> allUsers=new ArrayList<>();
		try {
			Connection conn=db.createConnection();
			String fetchUser=GetAllUsers;
			
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(fetchUser);
			
			if(rs != null){
				while(rs.next()){
					User user=new User(rs.getString(Name), rs.getString(Username), rs.getString(Password), rs.getString(Color));
					allUsers.add(user);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return allUsers;
	}
}
