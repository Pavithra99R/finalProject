package com.lti.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "CONTACT")
	private int contact;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "DOB")
	private LocalDate dob;
	
	@Column(name = "AUTHORIZED")
	private boolean authorized;
	
	@Column(name = "WALLET")
	private float wallet;
	
	@OneToMany(mappedBy = "user")
	private List<Booking> bookings;
	
	@OneToMany(mappedBy = "user")
	private List<Payment> payments;
	
	@OneToMany(mappedBy = "user")
	private List<Review> reviews;

	public int getUserId() {
		return UserId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public int getContact() {
		return contact;
	}

	public String getGender() {
		return gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public boolean isAuthorized() {
		return authorized;
	}

	public float getWallet() {
		return wallet;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public void setAuthorized(boolean authorized) {
		this.authorized = authorized;
	}

	public void setWallet(float wallet) {
		this.wallet = wallet;
	}
	
	

	
	

}
