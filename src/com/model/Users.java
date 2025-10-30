package com.model;

public class Users {
	String username,salt, password, name, surname, position, email;
	public String getUsername() {
		return username;
	}
	public String getSalt() {
		return salt;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getPosition() {
		return position;
	}
	public String getEmail() {
		return email;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setSalt(String salt) {
		this.salt=salt;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setSurname(String surname) {
		this.surname=surname;
	}
	public void setPosition(String position) {
		this.position=position;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
