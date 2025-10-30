package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.controller.LoginController;
import com.model.Client;
import com.model.Users;
import com.util.DbUtil;

public class ClientDao  {
	Connection conn6;
	static String err = "n/a";
	
	public ClientDao() {
		conn6 = DbUtil.getConnection();
	}
	public String bytesToHex(byte[] hash) {
	    StringBuffer hexString = new StringBuffer();
	    for (int i = 0; i < hash.length; i++) {
	    String hex = Integer.toHexString(0xff & hash[i]);
	    if(hex.length() == 1) hexString.append('0');
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}
	public String getAlphaNumericString(int n) 
    { 
  
        // chose a Character random from this String 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
  
        return sb.toString(); 
    } 
	public String signupusernameCheck(String username) {
		String answer=null;
        try {
            PreparedStatement preparedStatement = conn6.prepareStatement("SELECT * FROM USERS where username=?");
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next() == false) 
            { 
            	 answer="ok";
        	} 
            else 
            { 
            	answer="There is already a user with the username: "+username+", please enter a different username.";
        	}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answer;
    }
	public int addUser(Users newUser) {
		try {
			PreparedStatement stmt1 = conn6.prepareStatement("insert into PhoneBills.USERS (username, salt, password, position) values ( ?, ?,?,?);");
			stmt1.setString(1, newUser.getUsername());
			stmt1.setString(2, newUser.getSalt());
			stmt1.setString(3, newUser.getPassword());
			stmt1.setString(4, newUser.getPosition());
			stmt1.executeUpdate();		
		} catch (Exception sqle) {
			err = sqle.toString();
			sqle.printStackTrace();
			return 1;
		}
		return 0;
	}
	public int addClient(Client newClient) {
		try {
			PreparedStatement stmt = conn6.prepareStatement("insert into PhoneBills.CUSTOMERS (username, name,surname ,SELLERS_username, CUSTOMERSTaxNumber,email, create_time) values ( ?, ?,?,?,?,?, current_timestamp());");
			stmt.setString(1, newClient.getUsername());
			stmt.setString(2, newClient.getName());
			stmt.setString(3, newClient.getSurname());
			stmt.setString(4, LoginController.getAdmin());
			stmt.setString(5, newClient.getTaxnumber());
			stmt.setString(6, newClient.getEmail());
			stmt.executeUpdate();
			stmt.close();
	
		} catch (Exception sqle) {
			err = sqle.toString();
			sqle.printStackTrace();
			return 1;
		}
		return 0;
	}
	public double getMoney(String name) {
		double walletMoney=0;
		try {
			PreparedStatement stmt6 = conn6.prepareStatement("select * from phonebills.customers where username = ? ;");
			stmt6.setString(1, name);
			ResultSet rs3 = stmt6.executeQuery();
			if (rs3.next()) {
				walletMoney=rs3.getDouble("wallet");
		}
		}catch (Exception sqle) {
			err = sqle.toString();
			sqle.printStackTrace();
			return 1;
		}
		return walletMoney;
	}
	public int updateWallet(double money,String username) {
		double totalmoney=getMoney(username)+money;
		try {
			PreparedStatement stmt = conn6.prepareStatement("update PhoneBills.CUSTOMERS set wallet=? where username=?;");
			stmt.setDouble(1, totalmoney);
			stmt.setString(2, username);
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
