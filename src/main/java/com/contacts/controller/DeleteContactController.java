package com.contacts.controller;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.contacts.entity.Contact;
import com.contacts.exception.ResourceNotFoundException;
import com.contacts.forms.Singleform;
import com.contacts.service.ContactService;

@Controller
public class DeleteContactController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());	
	@Autowired
    private ContactService contactService;
	
	
	@Transactional
	@PostMapping("/delete_contact")
	public String deleteContact(
			@Valid @ModelAttribute("singleform") Singleform contactform , BindingResult vResult , Model model,RedirectAttributes redirectAttributes)
	{
		if(vResult.hasErrors())
		{
			System.out.println("Has Errors");
			redirectAttributes.addFlashAttribute("error", "Please select contact");
			return "redirect:/all_contacts";
			
		}
		System.out.println(contactform.getContactId());
		Contact c=new Contact();
		c.setContactId(contactform.getContactId());
		try {
			contactService.deleteContact(c);
		} catch (ResourceNotFoundException e) {
			model.addAttribute("contact", "Contact not found");
			logger.error(e.getMessage());
		}
			
		redirectAttributes.addFlashAttribute("msg","Contact Deleted Successfully");
		
		return "redirect:/all_contacts";
	
	}
	
	@PostMapping("/inactivate_contact")
	public String inactivateContact(
			@Valid @ModelAttribute("singleform") Singleform updateContact , BindingResult vResult , Model model,RedirectAttributes redirectAttributes)
	{
		if(vResult.hasErrors())
		{
			System.out.println("Has Errors");
			redirectAttributes.addFlashAttribute("error", "Please select contact");
			return "redirect:/all_contacts";
			
		}
		System.out.println(updateContact.getContactId());
		
		try {
			contactService.inActivateContact(updateContact.getContactId());
		} catch (ResourceNotFoundException e) {
			model.addAttribute("contact", "Contact already Inactive");
			logger.error(e.getMessage());
		}
		
		return "redirect:/all_contacts";
	
	}
	
	@PostMapping("/activate_contact")
	public String activateContact(
			@Valid @ModelAttribute("singleform") Singleform updateContact , BindingResult vResult , Model model,RedirectAttributes redirectAttributes)
	{
		if(vResult.hasErrors())
		{
			System.out.println("Has Errors");
			redirectAttributes.addFlashAttribute("error", "Please select contact");
			return "redirect:/all_contacts";
			
		}
		System.out.println(updateContact.getContactId());
		
		try {
			contactService.activateContact(updateContact.getContactId());
		} catch (ResourceNotFoundException e) {
			model.addAttribute("contact", "Contact already active");
		}
		
		return "redirect:/all_contacts";
	
	}
	
}
