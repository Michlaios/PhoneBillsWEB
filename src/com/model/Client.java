package com.model;

public class Client extends Users {
	String taxnumber;
	float wallet=0;
	public String getTaxnumber() {
		return taxnumber;
	}
	public void setTaxnumber(String taxnumber) {
		this.taxnumber=taxnumber;
	}
	public float getWallet() {
		return wallet;
	}
	public void setWallet(float money) {
		this.wallet=money;
	}
}
