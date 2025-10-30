package com.model;

public class Admin extends Users {
	public Admin() {
		super();
	}
	@Override
    public String toString() {
        return "Admin [Username=" + username + ", Email="
                + email + "]";
    }
}
