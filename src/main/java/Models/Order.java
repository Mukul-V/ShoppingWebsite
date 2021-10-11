package Models;
import java.time.LocalDateTime;

public class Order {
	
	public String products;
	public String OrderId;
	public LocalDateTime timestamp;
	
	public Order(String products) {
		LocalDateTime obj=LocalDateTime.now();
		timestamp=obj;
		OrderId="order"+obj;
		this.products=products;
	}
	
}
