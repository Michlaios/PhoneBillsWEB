package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Telephone_NumbersDao;
import com.dao.Number_StateDao;
import com.model.Telephone_Numbers;
import com.model.Programme;

/**
 * Servlet implementation class telephone_numberController
 */
@WebServlet("/number")
public class telephone_numberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Telephone_NumbersDao dao1;
	Number_StateDao dao2;
	String matchpacks = "/matchpacks.jsp";
    public telephone_numberController() {
        super();
        dao1 = new Telephone_NumbersDao();
        dao2= new Number_StateDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String topage = "/PhoneBillsWEB/actionerror.jsp", action = request.getParameter("action"), clientregister = "/clientregister.jsp", errorpage = "/actionerror.jsp";;
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		if (action.equalsIgnoreCase("clientregister")) {
			topage = clientregister;
			request.setAttribute("pack", dao2.getNumber());
		}
		else topage = errorpage;
		RequestDispatcher next = request.getRequestDispatcher(topage);
		next.forward(request, response);
	}
	
	
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		Telephone_Numbers newNumber= new Telephone_Numbers();
		String number=request.getParameter("number");
		newNumber.setNumber(number);
		newNumber.setProgramID(request.getParameter("idPROGRAMME"));	
		newNumber.setCostumersUsername(request.getParameter("clientusername"));
		if(request.getParameter("actionForServletNumber").equalsIgnoreCase("addNumber")){
			int success = dao1.addNumber(newNumber);//+dao2.setNumberAsUsed(number);
			request.setAttribute("err", dao1.giveErr());
			if (success == 0) {
				//dao2.setNumberAsUsed(number);
				RequestDispatcher next = request.getRequestDispatcher("/registersuccess.html");
				next.forward(request, response);
			} else {
				RequestDispatcher next = request.getRequestDispatcher("/registererror.jsp");
				next.forward(request, response);
			}
		}else if (request.getParameter("actionForServletNumber").equalsIgnoreCase("matchPack")) {
			int success=dao1.matchPacks(newNumber);
			if (success == 0) {
				RequestDispatcher next = request.getRequestDispatcher("/actionsuccess.jsp");
				next.forward(request, response);
			} else {
				RequestDispatcher next = request.getRequestDispatcher("/actionerror.jsp");
				next.forward(request, response);
			}
		} else {
			RequestDispatcher next = request.getRequestDispatcher("/actionerror.jsp");
			next.forward(request, response);
		}
	}
}
