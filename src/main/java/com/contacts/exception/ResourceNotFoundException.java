package com.contacts.exception;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends Exception {

	public ResourceNotFoundException() {
		// TODO Auto-generated constructor stub
	}


	public ResourceNotFoundException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	public ResourceNotFoundException(String msg) {
        super(msg);
    }  
	
}
