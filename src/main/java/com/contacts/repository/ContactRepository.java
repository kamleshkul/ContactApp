package com.contacts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.contacts.entity.Contact;


@Repository
public interface ContactRepository extends JpaRepository<Contact,Long>{
		
	@Query("update Contact c set status='Inactive' where status='Active' and c.contactId = :contactId")
	@Modifying
	 void inActivateContact(@Param("contactId") Long contactId);
	
	@Query("update Contact c set status='Active' where status='Inactive' and c.contactId = :contactId")
	@Modifying
	 void activateContact(@Param("contactId") Long contactId);
}
