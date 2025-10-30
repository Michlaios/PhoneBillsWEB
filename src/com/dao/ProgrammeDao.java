package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Programme;
import com.util.DbUtil;

public class ProgrammeDao {
	Connection conn4;
	static String err = "n/a";
	
	public ProgrammeDao() {
		conn4 = DbUtil.getConnection();
	}
	
	public int addProgramme(Programme newProgramme) {
		try {
			PreparedStatement stmt4 = conn4.prepareStatement("insert into PhoneBills.PROGRAMME (idPROGRAMME, PROGRAMMEDescription, PROGRAMMESpeechTime, PROGRAMMESMSNumber, PROGRAMMEData, PROGRAMMECost) values (?, ?, ?, ?, ?, ?);");
			stmt4.setString(1, String.valueOf(System.currentTimeMillis()));
			stmt4.setString(2, newProgramme.getTitle());
			stmt4.setInt(3, newProgramme.getMinutes());
			stmt4.setInt(4, newProgramme.getMessages());
			stmt4.setString(5, newProgramme.getData());
			stmt4.setFloat(6, newProgramme.getCost());
			stmt4.executeUpdate();
			stmt4.close();
		
		} catch (Exception sqle) {
			err = sqle.toString();
			sqle.printStackTrace();
			return 1;
		}
		return 0;
	}
	
	public int updateProgramme(Programme pack) {
		try {
			PreparedStatement stmt7 = conn4.prepareStatement("update PhoneBills.PROGRAMME set PROGRAMMEDescription = ?, PROGRAMMESpeechTime = ?, PROGRAMMESMSNumber = ?, PROGRAMMEData = ?, PROGRAMMECost = ? where idPROGRAMME = ?;");
			stmt7.setString(1, pack.getTitle());
			stmt7.setInt(2, pack.getMinutes());
			stmt7.setInt(3, pack.getMessages());
			stmt7.setString(4, pack.getData());
			stmt7.setFloat(5, pack.getCost());
			stmt7.setString(6, pack.getId());
			stmt7.executeUpdate();
		} catch (Exception sqle) {
			sqle.printStackTrace();
			return 1;
		}
		return 0;
	}
	
	public List<Programme> getAllPacks(){
		List<Programme> packs = new ArrayList<Programme>();
		try {
			Statement stmt5 = conn4.createStatement();
			ResultSet rs2 = stmt5.executeQuery("select * from phonebills.programme;");
			while (rs2.next()) {
				Programme pack = new Programme();
				pack.setId(rs2.getString("idPROGRAMME"));
				pack.setTitle(rs2.getString("PROGRAMMEDescription"));
				pack.setMinutes(Integer.parseInt(rs2.getString("PROGRAMMESpeechTime")));
				pack.setMessages(Integer.parseInt(rs2.getString("PROGRAMMESMSNumber")));
				pack.setData(rs2.getString("PROGRAMMEData"));
				pack.setCost(rs2.getFloat("PROGRAMMECost"));
				packs.add(pack);
			}
		} catch (Exception sqle) {
			sqle.printStackTrace();
		}
		return packs;
	}
	
	public Programme getPackById(String packid) {
		Programme pack = new Programme();
		try {
			PreparedStatement stmt6 = conn4.prepareStatement("select * from PhoneBills.PROGRAMME where idPROGRAMME = ?;");
			stmt6.setString(1, packid);
			ResultSet rs3 = stmt6.executeQuery();
			if (rs3.next()) {
				pack.setId(rs3.getString("idPROGRAMME"));
				pack.setTitle(rs3.getString("PROGRAMMEDescription"));
				pack.setMinutes(Integer.parseInt(rs3.getString("PROGRAMMESpeechTime")));
				pack.setMessages(Integer.parseInt(rs3.getString("PROGRAMMESMSNumber")));
				pack.setData(rs3.getString("PROGRAMMEData"));
				pack.setCost(rs3.getFloat("PROGRAMMECost"));
			}
		} catch (Exception sqle) {
			sqle.printStackTrace();
		}
		return pack;
	}
	
	public String giveErr() {
		return err;
	}
}
