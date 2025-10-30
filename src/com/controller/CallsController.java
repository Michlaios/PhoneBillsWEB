package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.CallsDao;
import com.dao.ProgrammeDao;
import com.model.Calls;

import com.model.Programme;

/**
 * Servlet implementation class CallsController
 */
@WebServlet("/calls")
public class CallsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CallsDao dao;
	String listCalls = "/listCalls.jsp",matchpacks = "/matchpacks.jsp", errorpage = "/actionerror.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CallsController() {
        super();
        dao = new CallsDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String topage = "/PhoneBillsWEB/actionerror.jsp", action = request.getParameter("action");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		if (action.equalsIgnoreCase("listCalls")) {
			topage = listCalls;
			String number=request.getParameter("number");
			String date=request.getParameter("date");
			request.setAttribute("call", dao.getCallsHistory(number,date));
			request.setAttribute("err", dao.giveErr());
		}
		else topage = errorpage;
		RequestDispatcher next = request.getRequestDispatcher(topage);
		next.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}
}
