package com.contacts.forms;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.contacts.annotation.Phone;


public class Contactform {
	
	@NotNull
	@Range(min=1,message="Select the contact")
	Long contactId;

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}
	
	private String firstName;
	@NotNull
	@Size(min=2, max=10)
	private String lastName;
	@NotNull
	@Email(message = "Please Enter Email ID in correct format.")
	private String emailId;
	@NotNull
	@Pattern(regexp ="^\\+?[0-9. ()-]{7,25}$", message = "Please Enter Phone number in correct format")
	@Phone
	private String phoneNumber;

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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
