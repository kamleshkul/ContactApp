package com.contacts.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contacts.entity.Contact;
import com.contacts.exception.BadResourceException;
import com.contacts.exception.ResourceAlreadyExistsException;
import com.contacts.exception.ResourceNotFoundException;
import com.contacts.repository.ContactRepository;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepository;
	
	public Contact findByContactId(Long contactId ) throws ResourceNotFoundException {
		 Contact contact = contactRepository.findById(contactId).orElse(null);
		 if (contact==null) {
	            throw new ResourceNotFoundException("Cannot find Contact with id: " + contactId);
	        }
	        else return contact;
		}
	
	
	public List<Contact> findAllContact() throws ResourceNotFoundException {
		return contactRepository.findAll();
	}
	
	@Transactional
	public 	void inActivateContact(Long contactId) throws ResourceNotFoundException{
		 contactRepository.inActivateContact(contactId);
	}

	@Transactional
	public 	void activateContact(Long contactId) throws ResourceNotFoundException{
		 contactRepository.activateContact(contactId);
	}
	public void deleteContact(Contact contact) throws ResourceNotFoundException {
		contactRepository.delete(contact);
	}


	public void save(Contact contact) throws BadResourceException, ResourceAlreadyExistsException{
		
		contactRepository.save(contact);		
	}

	
}
