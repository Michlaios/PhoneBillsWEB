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

import com.dao.ClientDao;
import com.model.Client;
/**
 * Servlet implementation class ClientController
 */
@WebServlet("/client")
public class ClientController extends HttpServlet {
	static final long serialVersionUID = 1L;
	ClientDao dao;
	public ClientController() {
		super();
		dao = new ClientDao();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("actionForServletClient");
		String actionBill= (String) request.getAttribute("actionForServletClient");
		if(action.equals("addClient")) {
		Client newClient = new Client();
		String salt=dao.getAlphaNumericString(16);
		String password=request.getParameter("clientpassword")+salt;
		String username=request.getParameter("clientusername");
		String usernamevalidation=dao.signupusernameCheck(username);
		if (usernamevalidation.equals("ok")) 
		{
			MessageDigest digest;
			try {
					digest = MessageDigest.getInstance("SHA-1");
					byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
					password=dao.bytesToHex(encodedhash);
					password =""+password;
					newClient.setName(request.getParameter("clientname"));
					newClient.setSurname(request.getParameter("clientsurname"));
					newClient.setUsername(request.getParameter("clientusername"));
					newClient.setPassword(password);
					newClient.setEmail(request.getParameter("clientemail"));
					newClient.setTaxnumber(request.getParameter("clienttaxnumber"));
					newClient.setPosition("Client");
					newClient.setSalt(salt);
			}
			catch (NoSuchAlgorithmException e) 
			{
				e.printStackTrace();
			}
		int success = dao.addUser(newClient)+dao.addClient(newClient);
		request.setAttribute("err", dao.giveErr());
		RequestDispatcher dispatch = request.getRequestDispatcher("/number");
		dispatch.forward(request, response);
		if (success == 0) {
			RequestDispatcher next = request.getRequestDispatcher("/actionsuccess.jsp");
			next.forward(request, response);
		} else {
			RequestDispatcher next = request.getRequestDispatcher("/actionerror.jsp");
			next.forward(request, response);
		}	
	}
		}else if(action.equals("paybill") && actionBill!=null){
			HttpSession session = request.getSession();
			//float moneyLeft=(Float)request.getAttribute("moneyRemain");
			//dao.updateWallet(moneyLeft, (String) session.getAttribute("name"));
			double cost = (double) request.getAttribute("finalCost");
			dao.updateWallet(-cost, (String) session.getAttribute("name"));
			 RequestDispatcher dispatcher = request.getRequestDispatcher("/actionsuccess.jsp");
			 dispatcher.forward(request, response);	
		}else if(action.equals("updateMoney")){
			HttpSession session = request.getSession();
			String name=(String) session.getAttribute("name");
			int success=dao.updateWallet(Integer.parseInt(request.getParameter("money")),name);
			if (success == 0) {
				RequestDispatcher next = request.getRequestDispatcher("/actionsuccess.jsp");
				next.forward(request, response);
			} else {
				RequestDispatcher next = request.getRequestDispatcher("/actionerror.jsp");
				next.forward(request, response);
			}
		}else if(action.equals("paybill") && actionBill==null) {
			HttpSession session = request.getSession();
			double moneyLeft= dao.getMoney((String) session.getAttribute("name"));
			 request.setAttribute("moneyLeft",moneyLeft);
			 RequestDispatcher dispatcher = request.getRequestDispatcher("/bill");
			 dispatcher.forward(request, response);
	}
}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if(action.equals("loadmoney")) {
			HttpSession session = request.getSession();
			request.setAttribute("money", dao.getMoney((String) session.getAttribute("name")));
			RequestDispatcher next = request.getRequestDispatcher("/updateWallet.jsp");
			next.forward(request, response);
		}
	}

}
