package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.controller.BillController;
import com.model.Calls;
import com.model.Programme;
import com.util.DbUtil;
public class CallsDao {
	Connection conn11;
	static String err = "n/a";
	
	public CallsDao() {
		conn11 = DbUtil.getConnection();
	}
	public List<Calls> getCallsHistory(String number, String date){
		List<Calls> calls = new ArrayList<Calls>();
		try {
			PreparedStatement stmt5 = conn11.prepareStatement("select * from phonebills.calls WHERE number=? AND CALLSTimestamp=?;");
			stmt5.setString(1, number);
			stmt5.setString(2, date);
			ResultSet rs2 = stmt5.executeQuery();
			while (rs2.next()) {
				Calls call = new Calls();
				call.setCallID(rs2.getString("idCALLS"));
				call.setCallDuration(rs2.getInt("CALLSDuration"));
				call.setCallDate(rs2.getString("CALLSTimestamp"));
				call.setNumber(rs2.getString("number"));
				call.setPackID(rs2.getString("IDprogramme"));
				calls.add(call);
			}
		} catch (Exception sqle) {
			err=sqle.toString();
			sqle.printStackTrace();
		}
		return calls;
	}
	public String giveErr() {
		return err;
	}
}