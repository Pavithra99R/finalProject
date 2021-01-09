package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "User") 
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="my_user_seq")
	@SequenceGenerator(sequenceName = "user_seq",allocationSize=1,name="my_user_seq")
	@Column(name = "USER_ID")
	private int UserId;
	
	@Column(name = "FIRST_NAME")
	private String FirstName;
	
	@Column(name = "LAST_NAME")
	private String LastName;
	
	@Column(name = "EMAIL")
	private String Email;
	
	@Column(name = "PASSWORD")
	private String Password;
	
	@Column(name = "CONTACT")
	private int Contact;
	
	@Column(name = "GENDER")
	private String Gender;
	
	@Column(name = "DOB")
	private LocalDate DOB;
	
	@Column(name = "AUTHORIZED")
	private boolean Authorized;
	
	@Column(name = "WALLET")
	private float Wallet;
	
	
	public int getUserId() {
		return UserId;
	}
	public String getFirstName() {
		return FirstName;
	}
	public String getLastName() {
		return LastName;
	}
	public String getEmail() {
		return Email;
	}
	public String getPassword() {
		return Password;
	}
	public int getContact() {
		return Contact;
	}
	public String getGender() {
		return Gender;
	}
	public LocalDate getDOB() {
		return DOB;
	}
	public boolean isAuthorized() {
		return Authorized;
	}
	public float getWallet() {
		return Wallet;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public void setContact(int contact) {
		Contact = contact;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}
	public void setAuthorized(boolean authorized) {
		Authorized = authorized;
	}
	public void setWallet(float wallet) {
		Wallet = wallet;
	}
	
	

}
