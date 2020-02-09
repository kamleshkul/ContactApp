package com.contacts.forms;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;


public class Singleform {
	
	@NotNull
	@Range(min=1,message="Select the contact")
	Long contactId;

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}
	
}
