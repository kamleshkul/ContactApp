package com.contacts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
public class ContactsManagementApplication  {

	public static void main(String[] args) {
		SpringApplication.run(ContactsManagementApplication.class, args);
		Logger logger= LoggerFactory.getLogger(ContactsManagementApplication.class);
		 logger.info("Application started "); 
	}

	}
