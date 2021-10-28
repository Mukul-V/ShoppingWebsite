package Models;
import java.util.HashMap;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.net.http.HttpResponse;
import java.util.ArrayList;


public class ProductsDao implements Helper{
	
	public Product getProduct(String id) {
		String url=API+PLP+GetProduct+id;
		HttpResponse res=APICall.getRequest(url);		
		Gson g=new Gson();
		Product product=g.fromJson(res.body().toString(), Product.class);
		return product;
	}

	public ArrayList<String> getAllIds() {
		
		String url=API+PLP+GetAllIds;
		HttpResponse res=APICall.getRequest(url);
		Gson g = new Gson();
		ArrayList<String> productsIds=g.fromJson(res.body().toString(),new TypeToken<ArrayList<String>>(){}.getType());
		
		return productsIds;
	}
	
	public ArrayList<Product> getAsList() {
		String url=API+PLP+GetAsList;
		HttpResponse res=APICall.getRequest(url);
		Gson g = new Gson();
		ArrayList<Product> productsList=g.fromJson(res.body().toString(),new TypeToken<ArrayList<Product>>(){}.getType());
	
		return productsList;
	}
	
	public HashMap<String, Product> getAsMap(){
		String url=API+PLP+GetAsMap;
		HttpResponse res=APICall.getRequest(url);
		Gson g = new Gson();
		HashMap<String, Product> productsMap=g.fromJson(res.body().toString(),new TypeToken<HashMap<String, Product>>(){}.getType());
	
		return productsMap;
	}

	
	
}
