package Models;

public class OrderTotal {

	public String orderId;
	public double total;
	
	public OrderTotal() {}
	
	public OrderTotal(String orderId,double total) {
		this.orderId=orderId;
		this.total=total;
	}

}
