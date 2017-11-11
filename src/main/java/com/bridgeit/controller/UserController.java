package com.bridgeit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bridgeit.model.User;
import com.bridgeit.service.Service;
import com.bridgeit.validation.Validation;

@Controller
public class UserController {

	@Autowired
	Service service;

	@Autowired
	User user;
	
	@Autowired
	Validation validate;

	@PostMapping("/registration")
	public ModelAndView registration(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();

		user.setUserName(request.getParameter("userName"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setNumber(Long.parseLong(request.getParameter("number")));
		if(validate.userValidate()) {
			String message = service.registrationValidate();
			modelAndView.setViewName("index.jsp");
			modelAndView.addObject("message", message);
			return modelAndView;
		}else
		modelAndView.setViewName("registration.jsp");
		modelAndView.addObject("message", "Please Enter Correct Values...");
			return modelAndView;
		}

	@PostMapping("/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
	
			ModelAndView modelAndView = new ModelAndView();
			user.setUserName(request.getParameter("userName"));
			user.setPassword(request.getParameter("password"));
			String name=service.loginValidate();
			if(name!=null) {
				
				HttpSession session=request.getSession();
				session.setAttribute("details", user.getUserName());
				modelAndView.setViewName("dashboard.jsp");
				return modelAndView;
				
			}else {
				modelAndView.setViewName("index.jsp");

				modelAndView.addObject("message", "Invalid Username or Password");
				return modelAndView;

			}
			

		
		}

	
	@PostMapping("/logout")
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session=request.getSession();
		session.invalidate();
		modelAndView.setViewName("index.jsp");

		modelAndView.addObject("message", "Logout Successfully...");
		return modelAndView;
		
	}
	
//	public void ajaxEmailValidation() {
//
//	}

	
	
}
