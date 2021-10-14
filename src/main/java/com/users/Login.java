package com.users;
import Models.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;


@WebServlet("/loginControl")
public class Login extends HttpServlet implements Helper{
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter(Username);
		String password=request.getParameter(Password);
		try {
			UserDao userDao=new UserDao();
			User user=userDao.signIn(username, password);
			
			if(user != null) {
				HttpSession session=request.getSession();
				session.setAttribute(User, user);
				response.sendRedirect(ProductListingJSP);
			}else {
				response.sendRedirect(LoginPage);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
