package com.bridgeit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.bridgeit.model.User;

public class UserController {
	
	@Autowired
	User user;
	public void login() {
		
	}
	
	public ModelAndView registration(HttpServletRequest request,HttpServletResponse response) {
		user.setUserName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setNumber(Long.parseLong(request.getParameter("number")));
		
		ModelAndView modelAndView=new ModelAndView();
		return modelAndView;
	}
	public void ajaxEmailValidation() {
		
	}
	public void logout() {
		
	}
}
