package com.cg.consumer.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.Pattern;

//import org.hibernate.validator.constraints.pl.REGON;

import com.sun.istack.NotNull;

@Entity
@Table(name = "user")
public class User {

	
	@NotNull
	@Column(name = "user_id", unique = true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;
	
	@Id
	@NotNull
	@Column(name = "user_name")
	private String userName;
	
	
	@NotNull
	@Column(name = "first_name")
	private String firstName;
	
	@NotNull
	@Column(name = "last_name")
	private String lastName;
	
	
	@Column(name = "user_contact")
	@Pattern(regexp = "^[6-9]{1}[0-9]{9}",message="length must be 10")
	@NotNull
	private Long userContact;
	
	
	
	public User() {
		
	}
	public User(Integer userId, String userName, String firstName, String lastName, Long userContact) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userContact = userContact;
	}


	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getUserContact() {
		return userContact;
	}

	public void setUserContact(Long userContact) {
		this.userContact = userContact;
	}

	

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", firstName=" + firstName + ", lastName="
				+ lastName + ", userContact=" + userContact + "]";
	}

	
	
	
}
