package com.users;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;

import Models.Helper;
import Models.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/newUser")
public class SignUp extends HttpServlet implements Helper{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name=req.getParameter(Name);
		String username=req.getParameter(Username);
		String password=req.getParameter(Password);
		String color=req.getParameter(Color);
		
		User user =new User(name, username, password, color);
		UserDao userDao=new UserDao();
		boolean successfulSignUp=userDao.signUp(user);
		HttpSession session = req.getSession();
		try {			
			if(successfulSignUp) {
				session.setAttribute(User, user);
				res.sendRedirect(ProductListingJSP);
			}else {
				res.sendRedirect(SignUpPage);
			}
			
		} catch(Exception e) {
			res.sendRedirect(SignUpPage);
		}
		
	}
}
