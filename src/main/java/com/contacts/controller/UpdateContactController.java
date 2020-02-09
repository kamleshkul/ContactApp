package com.contacts.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.contacts.entity.Contact;
import com.contacts.exception.BadResourceException;
import com.contacts.exception.ResourceAlreadyExistsException;
import com.contacts.exception.ResourceNotFoundException;
import com.contacts.forms.Singleform;
import com.contacts.forms.UpdateContactForm;
import com.contacts.service.ContactService;

@Controller
public class UpdateContactController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    private ContactService contactService;
	
	
	
	@PostMapping("/show_contact")
	public String updateForm(
			@Valid @ModelAttribute("singleform") Singleform contactform , BindingResult vResult , Model model,RedirectAttributes redirectAttributes )
	{
		if(vResult.hasErrors())
		{
			System.out.println("Has Errors");
			redirectAttributes.addFlashAttribute("error", "Please select contact");
			return "redirect:/all_contacts";
			
		}
		System.out.println(contactform.getContactId());
		Contact contact = null;
		try {
			contact = contactService.findByContactId(contactform.getContactId());
		} catch (ResourceNotFoundException e) {
			model.addAttribute("contact", "Contact not found");
			logger.error(e.getMessage());
		}
		
		model.addAttribute("con", contact);
		
		System.out.println("updateForm- "+contact.getContactId()+" "+contact.getFirstName()+" "+contact.getLastName()+" "+contact.getPhoneNumber()+" "+contact.getStatus()+" - "+  contact.getEmailId());
		return "edit_contact";
	}
	
	@RequestMapping("/update_contact")
	public String processForm(
			@ModelAttribute("updateContact") UpdateContactForm updateContact,HttpSession session, RedirectAttributes redirAttr)
	{
		
		System.out.println("processForm-"+ updateContact.getContactId() +" - "+  updateContact.getEmailId() +" - "+ updateContact.getFirstName()
		+updateContact.getLastName()+" - "+updateContact.getPhoneNumber()+" - "+updateContact.getStatus());
		
		Contact c=new Contact();
		c.setContactId(updateContact.getContactId());
		c.setEmailId(updateContact.getEmailId());
		c.setFirstName(updateContact.getFirstName());
		c.setLastName(updateContact.getLastName());
		c.setStatus(updateContact.getStatus());
		c.setPhoneNumber(updateContact.getPhoneNumber());
		
		try {
			contactService.save(c);
		} catch (BadResourceException e) {
			redirAttr.addAttribute("contact", "Failed to save Contact.");
			logger.error(e.getMessage());
		}
		catch (ResourceAlreadyExistsException e) {
			redirAttr.addAttribute("contact", "Contact already exist in the system.");
			logger.error(e.getMessage());
		}
		
		redirAttr.addFlashAttribute("msg","Contact Updated Succesfully");
		return "redirect:/all_contacts";
	}
	

}
