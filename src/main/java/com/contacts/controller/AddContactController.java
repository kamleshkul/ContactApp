package com.contacts.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.contacts.entity.Contact;
import com.contacts.exception.BadResourceException;
import com.contacts.exception.ResourceAlreadyExistsException;
import com.contacts.forms.AddContactForm;
import com.contacts.service.ContactService;
import com.contacts.validator.ContactValidator;

@Controller
public class AddContactController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ContactService contactService;
	@Autowired
    ContactValidator contactValidator;
	
	@Autowired
	private MessageSource messages;
    
	@InitBinder
	private void initBinder(WebDataBinder binder ) {
		
		binder.addValidators(contactValidator);
	}
	
	@GetMapping("/show_addcontact")
	public String showAddContactForm()
	{
		return "add_contact";
		
	}
	
	@PostMapping("/process_addcontact")
	public String processContactForm(
			@Valid @ModelAttribute("contactform") AddContactForm contactform,
			BindingResult bindingResult,Model theModel )
	{
		if(bindingResult.hasErrors())
		
		{
			if(bindingResult.getFieldError().getField().equals("firstName"))//firstname
				theModel.addAttribute("error",messages.getMessage("contactform.firstName.invalid", null, null));
				
			if(bindingResult.getFieldError().getField().equals("lastName"))//lastName
				theModel.addAttribute("error",messages.getMessage("contactform.lastName.invalid", null, null));
			
			if(bindingResult.getFieldError().getField().equals("emailId"))//emailId
			theModel.addAttribute("error",messages.getMessage("contactform.emailId.invalid", null, null));
			
			if(bindingResult.getFieldError().getField().equals("phoneNumber"))//emailId
				theModel.addAttribute("error",messages.getMessage("contactform.phoneNumber.invalid", null, null));
			
				
			return "add_contact";
		}
		
		System.out.println("Creating Contact ...");
		Contact contact=new Contact(contactform);
		
		try {
			contactService.save(contact);
		} catch (BadResourceException e) {
			theModel.addAttribute("contact", messages.getMessage("contactform.failed.invalid", null, null));
			logger.error(e.getMessage());
		}
		catch (ResourceAlreadyExistsException e) {
			theModel.addAttribute("contact", messages.getMessage("contactform.already.invalid", null, null));
			logger.error(e.getMessage());
		}
		
		theModel.addAttribute("error",messages.getMessage("contactform.added.success", null, null)); 
		return "add_contact";
	}
}
