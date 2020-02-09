package com.contacts.util;



public class ContactWrapper {
	
	private long contactId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String phoneNumber;
	private String status;
	
	

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
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


	public long getContactId() {
		return contactId;
	}


	public void setContactId(long contactId) {
		this.contactId = contactId;
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


	public ContactWrapper()
	{
		
	}
}


