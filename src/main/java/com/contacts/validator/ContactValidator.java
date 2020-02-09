package com.contacts.validator;

import java.util.Set;
import java.util.regex.Pattern;

import javax.validation.ConstraintViolation;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.contacts.entity.Contact;
import com.contacts.forms.AddContactForm;
import com.contacts.forms.Contactform;

@Component
public class ContactValidator implements Validator{
	  @Override
	   public boolean supports(Class<?> clazz) {
	      return AddContactForm.class.isAssignableFrom(clazz);//class.equals(clazz);
	      //User.class.isAssignableFrom(clazz);
	   }
	   @Override
	   public void validate(Object obj, Errors err) {

	      ValidationUtils.rejectIfEmpty(err, "firstName", "contactform.firstName.empty");
	      ValidationUtils.rejectIfEmpty(err, "lastName", "contactform.lastName.empty");
	      ValidationUtils.rejectIfEmpty(err, "emailId", "contactform.emailId.empty");
	      ValidationUtils.rejectIfEmpty(err, "phoneNumber", "contactform.phoneNumber.empty");

	      AddContactForm contact= (AddContactForm) obj;
	      
	      if(!contact.getFirstName().matches("[A-Z][a-z]*" ))
	    	  err.rejectValue("firstName", "contactform.firstName.invalid"); 
	      
	      if(!contact.getLastName().matches("[A-Z][a-z]*" ))
	    	  err.rejectValue("lastName", "contactform.lastName.invalid"); 

	      Pattern emailPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
	            Pattern.CASE_INSENSITIVE);
	      if (!(emailPattern.matcher(contact.getEmailId()).matches())) {
	         err.rejectValue("emailId", "contactform.emailId.invalid");
	      }
	      
	      Pattern phonePattern = Pattern.compile("\\d{10}",
		            Pattern.CASE_INSENSITIVE);
		      if (!(phonePattern.matcher(contact.getPhoneNumber()).matches())) {
		         err.rejectValue("phoneNumber", "contactform.phoneNumber.invalid");
		      }

	   }

	}