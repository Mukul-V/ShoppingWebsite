package Models;
import java.util.HashMap;

import com.users.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductsDao implements Helper{
	
	static DBConnection db=new DBConnection();

	public Product getProduct(String id) throws SQLException, ClassNotFoundException {
		String fetchProduct=GetProduct;
		Connection conn=db.createConnection();

		PreparedStatement st=conn.prepareStatement(fetchProduct);
		st.setString(1, id);
		ResultSet rs=st.executeQuery();
		Product product=null;
		
		while(rs.next()) {
			Product p=new Product(rs.getString(Id), rs.getString(Title), rs.getString(ImageUrl), 
					Double.parseDouble(rs.getString(Price)), rs.getString(Description), Integer.parseInt(rs.getString(Quantity)));
			product=p;
		}
		conn.close();
		return product;
	
	}
	//........

	public ArrayList<String> getAllIds() throws ClassNotFoundException, SQLException{
		Connection conn=db.createConnection();
		String fetchProducts=GetAllProducts;
		
		PreparedStatement st=conn.prepareStatement(fetchProducts);
		ResultSet rs=st.executeQuery();
		ArrayList<String> productsIds=new ArrayList<>();
		
		while(rs.next()) {
			String p=rs.getString(Id);
			productsIds.add(p);
		}
		
		conn.close();
		return productsIds;
	}
	
	public ArrayList<Product> getAsList() throws ClassNotFoundException, SQLException{
		Connection conn=db.createConnection();
		String fetchProducts=GetAllProducts;
		
		PreparedStatement st=conn.prepareStatement(fetchProducts);
		ResultSet rs=st.executeQuery();
		ArrayList<Product> productsList=new ArrayList<>();
		
		while(rs.next()) {
			Product p=new Product(rs.getString("id"), rs.getString("title"), rs.getString("imageUrl"), 
					Double.parseDouble(rs.getString("price")), rs.getString("description"), Integer.parseInt(rs.getString("quantity")));
			productsList.add(p);
		}
		
		conn.close();
		return productsList;
	}
	
	public HashMap<String, Product> getAsMap() throws SQLException, ClassNotFoundException{
		Connection conn=db.createConnection();
		String fetchProducts=GetAllProducts;
		
		PreparedStatement st=conn.prepareStatement(fetchProducts);
		ResultSet rs=st.executeQuery();
		HashMap<String, Product> productsMap=new HashMap<>();
		while(rs.next()) {
			Product p=new Product(rs.getString(Id), rs.getString(Title), rs.getString(ImageUrl), 
					Double.parseDouble(rs.getString(Price)), rs.getString(Description), Integer.parseInt(rs.getString(Quantity)));
			productsMap.put(p.id, p);
		}
		conn.close();
		return productsMap;
	}

	
	
}
