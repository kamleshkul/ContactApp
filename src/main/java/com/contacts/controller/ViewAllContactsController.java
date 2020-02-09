package com.contacts.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.contacts.entity.Contact;
import com.contacts.exception.ResourceNotFoundException;
import com.contacts.service.ContactService;
import com.contacts.util.ContactWrapper;

@Controller
public class ViewAllContactsController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ContactService contactService;

	@Autowired
	HttpSession httpSession;
	
	@GetMapping("/all_contacts")
	public String viewContacts(Model theModel, HttpServletRequest request)  {
		/* return "view_contact"; */

		List<Contact> contactList = null;
		try {
			contactList = contactService.findAllContact();
		} catch (ResourceNotFoundException e) {
			theModel.addAttribute("contact", "Contacts not found.");
			logger.error(e.getMessage());
		}

		try {
			HashMap<Long, ContactWrapper> contacts = new HashMap<Long, ContactWrapper>();
			if (contactList == null)
				return "view_contact";
			for (Contact ctemp : contactList) {
				ContactWrapper cw = new ContactWrapper();
				cw.setContactId(ctemp.getContactId());
				cw.setEmailId(ctemp.getEmailId());
				cw.setFirstName(ctemp.getFirstName());
				cw.setLastName(ctemp.getLastName());
				cw.setPhoneNumber(ctemp.getPhoneNumber());
				cw.setStatus(ctemp.getStatus());
				contacts.put(ctemp.getContactId(), cw);
				
			}

			theModel.addAttribute("clist", contacts);

			Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
			if (inputFlashMap != null) {
				if (inputFlashMap.get("error") != null)				
				{
					theModel.addAttribute("error", (String) inputFlashMap.get("error"));
				}
				if (inputFlashMap.get("msg") != null)				
				{
					
					theModel.addAttribute("error",(String) inputFlashMap.get("msg"));
				}

			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return "view_contact";

	}
}
