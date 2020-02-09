package com.contacts.forms;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddContactForm {
	@NotNull(message="is required")
	@Size(min=1, message="Firstname should not be Empty")
	String firstName;
	@NotNull(message="is required")
	@Size(min=1, message="Lastname should not be Empty")
	String lastName;
	@NotNull(message="is required")
	@Size(min=1, message="Email ID should not be Empty")
	String emailId;
	@NotNull(message="is required")
	String phoneNumber;
	@NotNull(message="is required")
	String status;
	
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
} 
