package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DbUtil;

public class LoginDao {
	Connection conn2;
	static String err = "n/a", customerPhone = "n/a";
	
	public LoginDao() {
		conn2 = DbUtil.getConnection();
	}
	public String getSalt(String username) {
		String salt=null;
        try {
            PreparedStatement preparedStatement = conn2.prepareStatement("SELECT salt from USERS where username=?");
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) 
            { 
            	salt=rs.getString("salt");
        	} 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salt;
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
	public String loginusernameCheck(String username) {
		String answer=null;
        try {
            PreparedStatement preparedStatement = conn2.prepareStatement("SELECT * from USERS where username=?");
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next() == false) 
            { 
            	 //answer="There is no user with the username: "+username+", please enter a valid username!";
            	 answer="wrong";
        	} 
            else 
            { 
            	answer=username;
        	}

            

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answer;
    }
	public String passwordCheck(String username,String password) {
		String answer=null;
		try {
            	PreparedStatement preparedStatement = conn2.prepareStatement("SELECT * from USERS where (username=? and password=?)");
            	preparedStatement.setString(1, username);
            	preparedStatement.setString(2, password);
            	ResultSet rs = preparedStatement.executeQuery();
            	if (rs.next() == false) 
            	{ 
            		answer="Wrong Password!";
            	} 
            	else 
            	{ 
            		answer="You logged in!";
            	}

        	} catch (SQLException e) {
            e.printStackTrace();
        	}
        return answer;
	}
	
	public String getCustomerPhone() {
		return customerPhone;
	}
	
	public String giveErr() {
		return err;
	}
}
