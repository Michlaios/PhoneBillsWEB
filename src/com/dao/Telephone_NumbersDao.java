package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.controller.LoginController;
import com.model.Programme;
import com.model.Telephone_Numbers;
import com.util.DbUtil;
public class Telephone_NumbersDao {
	Connection conn4;
	static String err = "n/a";
	
	public Telephone_NumbersDao() {
		conn4 = DbUtil.getConnection();
	}
	public int addNumber(Telephone_Numbers newNumber) {
		try {
			PreparedStatement stmt1 = conn4.prepareStatement("insert into PhoneBills.TELEPHONE_NUMBERS (idTELEPHONE_NUMBERS, PROGRAMME_idPROGRAMME, customers_username, customers_SELLERS_username) values ( ?, ?,?,?);");
			stmt1.setString(1, newNumber.getNumber());
			stmt1.setString(2, newNumber.getProgramID());
			stmt1.setString(3, newNumber.getCostumersUsername());
			stmt1.setString(4, LoginController.getAdmin());
			stmt1.executeUpdate();
			stmt1.close();
			conn4.close();
		} catch (Exception sqle) {
			err = sqle.toString();
			sqle.printStackTrace();
			return 1;
		}
		return 0;
	}
	public int updateNumber() {
		return 0;
	}
	public int matchPacks(Telephone_Numbers newNumber) {
		try {
			PreparedStatement stmt10 = conn4.prepareStatement("update PhoneBills.telephone_numbers SET PROGRAMME_idPROGRAMME=?, customers_SELLERS_username=? WHERE idTELEPHONE_NUMBERS=? AND customers_username=? ;");
			stmt10.setString(1, newNumber.getProgramID());
			stmt10.setString(2,LoginController.getAdmin());
			stmt10.setString(3, newNumber.getNumber());
			stmt10.setString(4, newNumber.getCostumersUsername());
			stmt10.executeUpdate();
		} catch (Exception sqle) {
			sqle.printStackTrace();
			return 1;
		}
		return 0;
	}
	
	public String giveErr() {
		return err;
	}

}
