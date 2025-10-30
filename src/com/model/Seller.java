package com.model;

public class Seller extends Users {
	public Seller() {
		super();
	}
	@Override
    public String toString() {
        return "Seller [Username=" + username + ", Email="
                + email + "]";
    }
}
