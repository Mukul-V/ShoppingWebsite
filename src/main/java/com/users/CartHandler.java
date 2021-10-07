package com.users;

import Models.Cart;
import Models.Helper;
import Models.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/cartHandler")
public class CartHandler extends HttpServlet implements Helper{
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		String id=request.getParameter(Id);
		User user=(User) session.getAttribute(User);
		
		CartDao cartDao=new CartDao();
		Cart cart=null;
				
		String handle=request.getParameter(Handle);
		try {
			
			if(handle.equals(AddToCartHandler)) {
				boolean result=cartDao.addToCart(user.username, id);
				System.out.println(result);
				response.sendRedirect(ProductListingJSP+"?"+Id+"="+id);
			}
			else if(handle.equals(RemoveFromHandler)) {
				boolean result=cartDao.removeFromCart(user.username, id);
				System.out.println(result);
				response.sendRedirect(ProductListingJSP+"?"+Id+"="+id);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
