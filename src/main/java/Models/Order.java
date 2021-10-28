package Models;
import java.time.LocalDateTime;

public class Order {
	public static int count;
	public String productId;
	public String orderId;
	public int quantity;
	
	public Order() {
		
	}
	
	public Order(String orderId, String productId, int quantity) {
		this.orderId=orderId;
		this.quantity=quantity;
		this.productId=productId;
	}

	
}
