package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Bill;
import com.model.Programme;
import com.dao.BillDao;
import com.dao.ProgrammeDao;

/**
 * Servlet implementation class BillController
 */
@WebServlet("/bill")
public class BillController extends HttpServlet {
	private static final long serialVersionUID = 1L;
			BillDao dao;
			ProgrammeDao dao2;
			String errorpage = "/actionerror.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillController() {
        super();
		dao = new BillDao();
		dao2= new ProgrammeDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		String id=request.getParameter("billID");
		if (action.equalsIgnoreCase("showbill")) {
			Bill bill= dao.getBill(id);
			request.setAttribute("bill", bill);
			RequestDispatcher next = request.getRequestDispatcher("/clientShowBill.jsp");
            next.forward(request, response);
		}else if (action.equalsIgnoreCase("listbills")) {
			request.setAttribute("bill", dao.getAllBills(request.getParameter("number")));
			RequestDispatcher next = request.getRequestDispatcher("/listbills.jsp");
			next.forward(request, response);
		}else {
			RequestDispatcher next = request.getRequestDispatcher("/actionerror.jsp");
			next.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("actionForServletBill");
		Bill newBill = new Bill();
		if (action.equalsIgnoreCase("temporaryExport")) {
			String number=request.getParameter("number");
			String date=request.getParameter("date");
			newBill.setnumber(number);
			newBill.setDate(date);
			newBill.setTotalduration(dao.calculateDuration(number,date));
			newBill.setProgramID(dao.getProgrammeId(number, date));
			Programme pack=new Programme();
			pack = dao2.getPackById(newBill.getProgramID());
			float baseCost=pack.getCost();
				if( newBill.getTotalDuration()<= (pack.getMinutes()*60)) newBill.settotalCost(baseCost);
				else {
					int timeDifference = newBill.getTotalDuration()-(pack.getMinutes()*60);
					double extraCost=(double) (timeDifference*0.005);//θεωρούμε οτι εφόσον κάποιος ξεπέρασε τα λεπτά που του προσφέρει το πακέτο, ξεκινάει να χρεώνεται 0.3$ το λεπτό ομιλίας.
					newBill.setExtraCost(extraCost);
					newBill.settotalCost(baseCost+extraCost);
				}
				request.setAttribute("bill", newBill);
				request.setAttribute("pack", pack);
				RequestDispatcher next = request.getRequestDispatcher("/createFinalBill.jsp");
				next.forward(request, response);
		}else if (action.equalsIgnoreCase("createFinalBill")) {
			newBill.setDate(request.getParameter("date"));
			newBill.setnumber(request.getParameter("number"));
			newBill.setProgramID(request.getParameter("packID"));
			newBill.setExtraCost(Double.parseDouble(request.getParameter("extraCost")));
			newBill.settotalCost(Double.parseDouble(request.getParameter("totalCost")));
			int success=dao.addBill(newBill);
			request.setAttribute("err", dao.giveErr());
			if (success == 0) {
				RequestDispatcher next = request.getRequestDispatcher("/actionsuccess.jsp");
				next.forward(request, response);
			} else {
				RequestDispatcher next = request.getRequestDispatcher("/actionerror.jsp");
				next.forward(request, response);
			}
		}else if(action.equals("paybill")) {
			double moneyLeft = (double) request.getAttribute("moneyLeft");
			if(moneyLeft < Double.parseDouble(request.getParameter("totalCost"))) {
				RequestDispatcher next = request.getRequestDispatcher("/payerror.jsp");
				next.forward(request, response);
			}else {
				double  finalCost=Double.parseDouble(request.getParameter("totalCost"));
				request.setAttribute("finalCost", finalCost);
				request.setAttribute("actionForServletClient","updateWallet");
				dao.setBillAsPaid(request.getParameter("number"),request.getParameter("date"));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/client");
				dispatcher.forward(request, response);
			}
		}else {
			RequestDispatcher next = request.getRequestDispatcher("/actionerror.jsp");
			next.forward(request, response);
		}
	}
}
