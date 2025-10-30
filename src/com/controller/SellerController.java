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

import com.dao.SellerDao;
import com.model.Seller;
@WebServlet("/seller")
public class SellerController extends HttpServlet {
	static final long serialVersionUID = 1L;
	SellerDao dao;
	public SellerController() {
		super();
		dao = new SellerDao();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		Seller newSeller = new Seller();
		String salt=dao.getAlphaNumericString(16);
		String password=request.getParameter("sellerpassword")+salt;
		String username=request.getParameter("sellersurname");
		String usernamevalidation=dao.signupusernameCheck(username);
		if (usernamevalidation.equals("ok")) 
		{
			MessageDigest digest;
			try {
					digest = MessageDigest.getInstance("SHA-1");
					byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
					password=dao.bytesToHex(encodedhash);
					password =""+password;
					newSeller.setName(request.getParameter("sellername"));
					newSeller.setSurname(request.getParameter("sellersurname"));
					newSeller.setEmail(request.getParameter("selleremail"));
					newSeller.setPosition("Seller");
					newSeller.setSalt(salt);
					newSeller.setPassword(password);
					newSeller.setUsername(request.getParameter("sellerusername"));
			}
			catch (NoSuchAlgorithmException e) 
			{
				e.printStackTrace();
			}
		int success2= dao.addUser(newSeller);
		int success1 = dao.addSeller(newSeller);
		int success=success1+success2;
		request.setAttribute("err", dao.giveErr());
		if (success == 0) {
			RequestDispatcher next = request.getRequestDispatcher("/actionsuccess.jsp");
			next.forward(request, response);
		} else {
			RequestDispatcher next = request.getRequestDispatcher("/actionerror.jsp");
			next.forward(request, response);
		}
	}
}	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
