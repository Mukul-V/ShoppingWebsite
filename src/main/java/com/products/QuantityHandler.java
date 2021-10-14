package com.products;
import java.sql.SQLException;

import com.users.CartDao;

import Models.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/handler")
public class QuantityHandler extends HttpServlet implements Helper{

	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		String id=request.getParameter(Id);
		User user=(User) session.getAttribute(User);
		
		CartDao cartDao=new CartDao();
		Cart cart=null;
				
		String handle=request.getParameter(Handle);
		try {
			cart = cartDao.getCartItem(user.username, id);
			
			if(handle.equals(Increment)) {	
				cart.increaseQuantity(user.username, id);
				response.sendRedirect(CartJSP);
			}
			else if(handle.equals(Decrement)) {
				cart.decreaseQuantity(user.username, id);
				response.sendRedirect(CartJSP);
			}
			else if(handle.equals(Delete)){
				cartDao.removeFromCart(user.username, id);
				response.sendRedirect(CartJSP);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
