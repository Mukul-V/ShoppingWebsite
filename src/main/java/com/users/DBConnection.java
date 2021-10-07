package com.users;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection implements DBHelper{

	public Connection createConnection() throws ClassNotFoundException {
		Connection conn=null;
		Class.forName(DriverClass);
		
		final String url=Url;
		try {
			conn=DriverManager.getConnection(url, Username, Password);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return conn;
	}

}
