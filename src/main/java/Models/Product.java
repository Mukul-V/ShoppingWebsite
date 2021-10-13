package Models;

import java.sql.*;

import com.users.DBConnection;

public class Product{
	public String id;
	public String title;
	public String ImageUrl;
	public double price;
	public String description;
	//public int qty;
	
	public Product(String id,String title, String ImageUrl, double price, String description) {
		this.id=id;
		this.title=title;
		this.ImageUrl=ImageUrl;
		this.price=price;
		this.description=description;
//		this.qty=qty;
	}
}