package com.contacts.entity;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.contacts.annotation.Phone;
import com.contacts.forms.AddContactForm;

@Entity
//@Table(name = "contacts")
public class Contact {
	
	public Contact(AddContactForm contactform) {
		// TODO Auto-generated constructor stub
		this.setFirstName(contactform.getFirstName());
		this.setLastName(contactform.getLastName());
		this.setEmailId(contactform.getEmailId());
		this.setPhoneNumber(contactform.getPhoneNumber());
		this.setStatus(contactform.getStatus());
	}
	public Contact() {
		// TODO Auto-generated constructor stub
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long contactId;
	@NotNull
	@Size(min=1, max=50) 
	private String firstName;
	@NotNull
	@Size(min=1, max=50)
	private String lastName;
	@NotNull
	@Email(message = "Please Enter Email ID in correct format.")
	private String emailId;

	@Pattern(regexp ="^\\+?[0-9. ()-]{7,25}$", message = "Please Enter Phone number in correct format")
	@Phone
	private String phoneNumber;
	@NotNull
	private String status;
	
	public long getContactId() {
		return contactId;
	}
	public void setContactId(long contactId) {
		this.contactId = contactId;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	}
