package com.model;

public class Bill {
String billID,number, date,programID;
int  totalDuration;
double totalCost=0, extraCost=0;
String paid="OXI";
public void  setnumber(String number) {
	this.number=number;
}
public void setBillID(String id) {
	this.billID=id;
}
public void setExtraCost(double extra){
	this.extraCost=extra;
}
public void  setTotalduration(int totalDuration) {
	this.totalDuration=totalDuration;
}
public void  setProgramID(String id) {
	this.programID=id;
}
public void setDate(String date) {
	this.date=date;
}
public void settotalCost(double cost) {
	this.totalCost=cost;
}
public void setPaid(String paid) {
	this.paid=paid;
}
public String getNumber() {
	return number;
}
public String getDate() {
	return date;
}
public String getpaid() {
	return paid;
}
public String getBillID() {
	return billID;
}
public String getProgramID() {
	return programID;
}
public int getTotalDuration() {
	return totalDuration;
}
public double getExtraCost() {
	return extraCost;
}
public double getTotalCost() {
	return totalCost;
}
}
