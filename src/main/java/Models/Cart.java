package Models;

import com.users.CartDao;

public class Cart {
	String username;
	String productId;
	int quantity;
	
	public Cart() {}
	
	public Cart(String username, String productId, int quantity) {
		this.username=username;
		this.productId=productId;
		this.quantity=quantity;
	}

	public String getUsername() {
		return username;
	}
	public String getProductId() {
		return productId;
	}
	public int getQuantity() {
		return quantity;
	}
	
	public boolean increaseQuantity(String username, String productId) {
		boolean result=false;
		this.quantity+=1;
		
		CartDao cartDao=new CartDao();
	
		try {
			result=cartDao.changeQuantity(username, productId, this.quantity);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	public boolean decreaseQuantity(String username, String productId) {
		boolean result=false;
		
		if(this.quantity <= 0) {
			return false;
		}
		
		this.quantity-=1;
		
		CartDao cartDao=new CartDao();
	
		try {
			result=cartDao.changeQuantity(username, productId, this.quantity);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
