package com.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.LoginDao;
import com.model.Login;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	static final long serialVersionUID = 1L;
	static String adminusername;
	LoginDao dao;
	
	public LoginController() {
		super();
		dao = new LoginDao();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		Login newLogin = new Login();
		newLogin.setUsername(request.getParameter("loginusername"));
		newLogin.setPassword(request.getParameter("loginpassword"));
		newLogin.setProperty(request.getParameter("usrprop"));
		String username=request.getParameter("loginusername");
		String password=request.getParameter("loginpassword");
		String property=request.getParameter("usrprop");
		String usernamevalidation=dao.loginusernameCheck(username);
		
		if (usernamevalidation.equals("wrong")) 
		{
			request.setAttribute("message", usernamevalidation);
			request.setAttribute("username", username);
			RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
			view.forward(request, response);
		}else 
		{
			password=password+dao.getSalt(username);
			MessageDigest digest;
			try {
					digest = MessageDigest.getInstance("SHA-1");
					byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
					password=dao.bytesToHex(encodedhash);
					String passwordvalidation=dao.passwordCheck(username, password);
					
					if (passwordvalidation.equals("You logged in!")) 
						
					{
						HttpSession session = request.getSession(true);
						synchronized(session) 
						{	
							session.setAttribute("name", username);
							session.setAttribute("username", adminusername = newLogin.getUsername());
							session.setAttribute("property", newLogin.getProperty());
														
														
							if (property.equalsIgnoreCase("admin")) 
							{
								RequestDispatcher next = request.getRequestDispatcher("/adminmenu.jsp");
								next.forward(request, response);
							}
							else if (property.equalsIgnoreCase("customer")) 
							{
								RequestDispatcher next = request.getRequestDispatcher("/clientmenu.jsp");
								next.forward(request, response);
							
							}
							else 
							{
								RequestDispatcher next = request.getRequestDispatcher("/sellermenu.jsp");
								next.forward(request, response);
							}
						}
					}									
					else 
					{
						RequestDispatcher next = request.getRequestDispatcher("/loginerror.jsp");
						next.forward(request, response);
					}
				} 
				catch (NoSuchAlgorithmException e) 
				{
					e.printStackTrace();
				}
		}	
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	public static String getAdmin() {
		if (adminusername == null) return "n/a";
		return adminusername;
	}
}
