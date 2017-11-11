package com.bridgeit.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bridgeit.model.User;
@Component
public class Validation {

	@Autowired
	User user;
	
	
public boolean userValidate() {
	boolean status=true;
	String email="/^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$/";
	String number="/^([9]{1})([234789]{1})([0-9]{8})$/";
	String username="/^[a-zA-Z]{4,15}/";
	String userNumber=Long.toString(user.getNumber());
	
	if(!username.matches(user.getUserName())) {
		return false;
	}
	else if(!email.matches(user.getEmail())) {
		return false;
	}
	else if(!number.matches(userNumber)) {
		return false;
	}
	return status;
}
	
}
