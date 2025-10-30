package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.controller.BillController;
import com.model.Bill;
import com.model.Programme;
import com.util.DbUtil;
public class BillDao {
	Connection conn10;
	static String err = "n/a";
	
	public BillDao() {
		conn10 = DbUtil.getConnection();
	}
	public int calculateDuration(String number, String date) {
		int duration=0;
		try {
			PreparedStatement stmt6 = conn10.prepareStatement("select * from PhoneBills.calls where number = ? AND CALLSTimestamp=? ;");
			stmt6.setString(1, number);
			stmt6.setString(2, date);
			ResultSet rs3 = stmt6.executeQuery();
	        while (rs3.next()) {	
				duration+=rs3.getInt("CALLSDuration");
			}
		} catch (Exception sqle) {
			sqle.printStackTrace();
		}
		return duration;
	}
	public String getProgrammeId(String number, String date) {
		String packID="";
		try {
			PreparedStatement stmt6 = conn10.prepareStatement("select * from PhoneBills.calls where number = ? AND CALLSTimestamp=? LIMIT 1 ;");
			stmt6.setString(1, number);
			stmt6.setString(2, date);
			ResultSet rs3 = stmt6.executeQuery();
			if (rs3.next()) {	
				packID=rs3.getString("IDprogramme");
			}
		} catch (Exception sqle) {
			sqle.printStackTrace();
		}
		return packID;
	}
	public int addBill(Bill newBill) {
		try {
			PreparedStatement stmt6 = conn10.prepareStatement("insert into PhoneBills.bills (idBILLS, BILLSMonth, TELEPHONE_NUMBERS_idTELEPHONE_NUMBERS, TELEPHONE_NUMBERS_PROGRAMME_idPROGRAMME,extraCost,totalCost, BILLSPayment) values (?, ?, ?, ?, ?,?,?);");
			stmt6.setString(1, String.valueOf(System.currentTimeMillis()));
			stmt6.setString(2, newBill.getDate());
			stmt6.setString(3, newBill.getNumber());
			stmt6.setString(4, newBill.getProgramID());
			stmt6.setDouble(5, newBill.getExtraCost());
			stmt6.setDouble(6, newBill.getTotalCost());
			stmt6.setString(7, "OXI");
			stmt6.executeUpdate();
			stmt6.close();
		} catch (Exception sqle) {
			err=sqle.toString();
			sqle.printStackTrace();
			return 1;
		}
		return 0;
	}
	public Bill getBill(String id) {
		Bill bill = new Bill();
		try {
			PreparedStatement stmt6 = conn10.prepareStatement("select * from phonebills.bills where idBILLS = ? ;");
			stmt6.setString(1, id);
			ResultSet rs3 = stmt6.executeQuery();
			while (rs3.next()) {
				bill.setBillID(rs3.getString("idBILLS"));
				bill.setnumber(rs3.getString("TELEPHONE_NUMBERS_idTELEPHONE_NUMBERS"));
				bill.setDate(rs3.getString("BILLSMonth"));
				bill.setProgramID(rs3.getString("TELEPHONE_NUMBERS_PROGRAMME_idPROGRAMME"));
				bill.setExtraCost(rs3.getInt("extraCost"));
				bill.settotalCost(rs3.getInt("totalCost"));
				bill.setPaid(rs3.getString("BILLSPayment"));
			}
		} catch (Exception sqle) {
			sqle.printStackTrace();
		}
		return bill;
	}
	public List<Bill> getAllBills(String number){
		List<Bill> bills = new ArrayList<Bill>();
		try {
			PreparedStatement stmt6 = conn10.prepareStatement("select * from phonebills.bills where TELEPHONE_NUMBERS_idTELEPHONE_NUMBERS = ? ;");
			stmt6.setString(1, number);
			ResultSet rs2 = stmt6.executeQuery();
			while (rs2.next()) {
				Bill bill = new Bill();
				bill.setBillID(rs2.getString("idBILLS"));
				bill.setProgramID(rs2.getString("TELEPHONE_NUMBERS_PROGRAMME_idPROGRAMME"));
				bill.setDate(rs2.getString("BILLSMonth"));
				bill.setPaid(rs2.getString("BILLSPayment"));
				bills.add(bill);
			}
		} catch (Exception sqle) {
			sqle.printStackTrace();
		}
		return bills;
	}
	public int setBillAsPaid(String number, String date) {
		try {
			PreparedStatement stmt = conn10.prepareStatement("update PhoneBills.bills set BILLSPayment=? where TELEPHONE_NUMBERS_idTELEPHONE_NUMBERS=? AND BILLSMonth=?;");
			stmt.setString(1, "NAI");
			stmt.setString(2, number);
			stmt.setString(3, date);
			stmt.executeUpdate();
			stmt.close();

		} catch (Exception sqle) {
			err = sqle.toString();
			sqle.printStackTrace();
			return 1;
		}
		return 0;
	}
	public String giveErr() {
		return err;
	}
}
