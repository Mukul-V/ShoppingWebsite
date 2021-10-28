package Models;

import java.sql.*;

import com.users.DBConnection;

public class Product{
	public String id;
	public String title;
	public String imageUrl;
	public double price;
	public String description;

	
	public Product(String id,String title, String imageUrl, double price, String description) {
		this.id=id;
		this.title=title;
		this.imageUrl=imageUrl;
		this.price=price;
		this.description=description;

	}
}