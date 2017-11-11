
package com.bridgeit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bridgeit.dao.LoginDao;
import com.bridgeit.dao.RegistrationDao;

@Component
public class ServiceImp implements Service{

	@Autowired
	RegistrationDao register;
	@Autowired
	LoginDao login;
	
	public String registrationValidate() {
		String result=register.emailValidaton();
		return result;
		}
	
	public String loginValidate() {
		String result=login.loginValidate();
		return result;
		
	}
	
}
