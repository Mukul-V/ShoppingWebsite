package com.users;
import java.time.LocalDateTime;
import java.util.*;
import Models.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;


@WebServlet("/orderHandler")



public class OrdersHandler extends HttpServlet implements Helper{
	
	public static String getTime() {
		LocalDateTime obj=LocalDateTime.now();
		return obj+"";
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session=req.getSession();
		User user=(User) session.getAttribute(User);
		
		String handle=req.getParameter(Handle);
		if(handle.equals(OrderNow)) {
			
			CartDao cartDao=new CartDao();
			
			String orderId="order"+getTime();
			try{
				ArrayList<Cart> cart=cartDao.getCart(user.username);
				ProductsDao products=new ProductsDao();
				OrdersDao ordersDao=new OrdersDao();
				double total=0;
				Order order=null;
				
				for(Cart cartItem: cart) {
					order=new Order(orderId, cartItem.getProductId(), cartItem.getQuantity());
					ordersDao.addOrder(user.username, order);
					
					Product product=products.getProduct(cartItem.getProductId());
					cartDao.removeFromCart(user.username, cartItem.getProductId());
					
					total+=(order.quantity * product.price);
				}
				
				OrderTotal orderTotal=new OrderTotal(orderId, total);
				ordersDao.addOrderTotal(user.username, orderTotal);
				
				
				res.sendRedirect(OrdersJSP);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
