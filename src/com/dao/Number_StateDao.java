package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Programme;
import com.util.DbUtil;
public class Number_StateDao {
	Connection conn9;
	static String err = "n/a";
	
	public Number_StateDao() {
		conn9 = DbUtil.getConnection();
	}
	public String getNumber(){
		String availableNumber="";
		try {
			Statement stmt5 = conn9.createStatement();
			ResultSet rs2 = stmt5.executeQuery("select * from phonebills.numbers_state WHERE used IS NULL LIMIT 1;");
			if (rs2.next()) {
	            availableNumber = rs2.getString("number");
	            String updateQuery = "UPDATE phonebills.numbers_state SET used = 1 WHERE number = ?";
	            PreparedStatement pstmt = conn9.prepareStatement(updateQuery);
	            pstmt.setString(1, availableNumber);
	            pstmt.executeUpdate();
	        }			
		} catch (Exception sqle) {
			sqle.printStackTrace();
			err = sqle.toString();
		}
		return availableNumber;
	}
	public int setNumberAsUsed(String number) {
		try {
			String updateQuery = "update phonebills.numbers_state SET used=1 WHERE number=?";
	        PreparedStatement pstmt = conn9.prepareStatement(updateQuery);
	        pstmt.setString(1, number);
	        pstmt.executeUpdate();
	       
		}catch(Exception sqle) {
			err = sqle.toString();
			sqle.printStackTrace();
			return 1;
		}
		return 0;
	}
}
