package com.app.entity;

public class User{
	 
	private String username;
	private String email;

	public User(String username, String email) {

		this.username = username;
		this.email = email;
	}


	public User() {
		 
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String user) {
		this.username = user;
	}

	public String getMail() {
		return email;
	}

	public void setMail(String mail) {
		this.email = mail;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + "]";
	}

}
