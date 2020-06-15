package com.cg.consumer.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "login")
public class Login {

	@Id
	@NotNull
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "user_password")
	@NotNull
	private String userPassword;
	
	@Column(name="role")
	@NotNull
	private String role;

	public Login() {
		super();
	}

	public Login(String userName, String userPassword, String role) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Login [userName=" + userName + ", userPassword=" + userPassword + ", role=" + role + "]";
	}
	
	
	
	
}
