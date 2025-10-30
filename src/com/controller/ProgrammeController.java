package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Number_StateDao;
import com.dao.ProgrammeDao;
import com.model.Programme;

@WebServlet("/programme")
public class ProgrammeController extends HttpServlet {
	static final long serialVersionUID = 1L;
	String addpack = "/addpack.jsp", editpack = "/editpack.jsp", listpacks = "/listpacks.jsp",matchpacks = "/matchpacks.jsp", errorpage = "/actionerror.jsp";
	ProgrammeDao dao;
	Number_StateDao dao2;
	
	public ProgrammeController() {
		super();
		dao = new ProgrammeDao();
		dao2= new Number_StateDao();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		Programme newProgramme = new Programme();
		newProgramme.setTitle(request.getParameter("packtitle"));
		newProgramme.setMinutes(Integer.parseInt(request.getParameter("mins")));
		newProgramme.setMessages(Integer.parseInt(request.getParameter("msgs")));
		newProgramme.setData(request.getParameter("data"));
		newProgramme.setCost(Float.parseFloat(request.getParameter("pcost")));
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("addpack")) {
			int success = dao.addProgramme(newProgramme);
			request.setAttribute("err", dao.giveErr());
			if (success == 0) {
				RequestDispatcher next = request.getRequestDispatcher("/actionsuccess.jsp");
				next.forward(request, response);
			} else {
				RequestDispatcher next = request.getRequestDispatcher("/actionerror.jsp");
				next.forward(request, response);
			}	
		} else if (action.equalsIgnoreCase("editpack")) {
			newProgramme.setId(request.getParameter("packid"));
			int success = dao.updateProgramme(newProgramme);
			request.setAttribute("err", dao.giveErr());
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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String topage = "/PhoneBillsWEB/actionerror.jsp", action = request.getParameter("action");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		if (action.equalsIgnoreCase("addpack")) topage = addpack;
		else if (action.equalsIgnoreCase("listpacks")) {
			topage = listpacks;
			request.setAttribute("pack", dao.getAllPacks());
		}
		else if (action.equalsIgnoreCase("editpack")) {
			topage = editpack;
			String packid = request.getParameter("idPROGRAMME");
			Programme pack = dao.getPackById(packid);
			request.setAttribute("pack", pack);
		}
		else if (action.equalsIgnoreCase("matchpacks")) {
			topage = matchpacks;
			request.setAttribute("pack", dao.getAllPacks());
			request.setAttribute("pack2", dao2.getNumber());
		}
		else topage = errorpage;
		RequestDispatcher next = request.getRequestDispatcher(topage);
		next.forward(request, response);
	}
}
