package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Admin;
import com.model.Users;
import com.util.DbUtil;
public class AdminDao {
	Connection conn;
	static String err = "n/a";
	
	public AdminDao() {
		conn = DbUtil.getConnection();
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
	public String bytesToHex(byte[] hash) {
	    StringBuffer hexString = new StringBuffer();
	    for (int i = 0; i < hash.length; i++) {
	    String hex = Integer.toHexString(0xff & hash[i]);
	    if(hex.length() == 1) hexString.append('0');
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}
	public int addUser(Users newUser) {
		try {
			PreparedStatement stmt1 = conn.prepareStatement("insert into PhoneBills.USERS (username, salt, password, position) values ( ?, ?,?,?);");
			stmt1.setString(1, newUser.getUsername());
			stmt1.setString(2, newUser.getSalt());
			stmt1.setString(3, newUser.getPassword());
			stmt1.setString(4, newUser.getPosition());
			stmt1.executeUpdate();
			stmt1.close();
			
		} catch (Exception sqle) {
			err = sqle.toString();
			sqle.printStackTrace();
			return 1;
		}
		return 0;
	}
	public String signupusernameCheck(String username) {
		String answer=null;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM USERS where username=?");
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
	public int addAdmin(Admin newAdmin) {
		try {
			PreparedStatement stmt = conn.prepareStatement("insert into PhoneBills.ADMINS (username, name,surname,email, create_time) values ( ?, ?,?,?, current_timestamp());");
			stmt.setString(1, newAdmin.getUsername());
			stmt.setString(2, newAdmin.getName());
			stmt.setString(3, newAdmin.getSurname());
			stmt.setString(4, newAdmin.getEmail());
			stmt.executeUpdate();
			stmt.close();
			conn.close();
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
