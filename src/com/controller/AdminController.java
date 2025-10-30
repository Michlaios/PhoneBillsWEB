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

import com.dao.AdminDao;
import com.model.Admin;

@WebServlet("/admin")
public class AdminController extends HttpServlet {
	static final long serialVersionUID = 1L;
	AdminDao dao;
	public AdminController() {
		super();
		dao = new AdminDao();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		Admin newAdmin = new Admin();
		String salt=dao.getAlphaNumericString(16);
		String username=request.getParameter("adminsurname");
		String password=request.getParameter("adminpassword")+salt;
		String usernamevalidation=dao.signupusernameCheck(username);
		if (usernamevalidation.equals("ok")) 
		{
			MessageDigest digest;
			try {
					digest = MessageDigest.getInstance("SHA-1");
					byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
					password=dao.bytesToHex(encodedhash);
					password =""+password;
					newAdmin.setName(request.getParameter("adminname"));
					newAdmin.setSurname(request.getParameter("adminsurname"));	
					newAdmin.setEmail(request.getParameter("adminemail"));
					newAdmin.setPosition("Admin");
					newAdmin.setSalt(salt);
					newAdmin.setPassword(password);
					newAdmin.setUsername(request.getParameter("adminusername"));
			}
			catch (NoSuchAlgorithmException e) 
			{
				e.printStackTrace();
			}
		int success =dao.addUser(newAdmin)+ dao.addAdmin(newAdmin);
		request.setAttribute("err", dao.giveErr());
		if (success == 0) {
			RequestDispatcher next = request.getRequestDispatcher("/registersuccess.html");
			next.forward(request, response);
		} else {
			RequestDispatcher next = request.getRequestDispatcher("/registererror.jsp");
			next.forward(request, response);
		}
	}
}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
