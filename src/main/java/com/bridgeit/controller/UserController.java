package com.bridgeit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bridgeit.dao.RegistrationDao;
import com.bridgeit.model.User;

@Controller
public class UserController {

	@Autowired
	RegistrationDao register;

	@Autowired
	User user;

	@PostMapping("/registration")
	public ModelAndView registration(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();

		user.setUserName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		System.out.println(user.getEmail());
		user.setPassword(request.getParameter("password"));
		user.setNumber(Long.parseLong(request.getParameter("number")));
		String message = register.emailValidaton();
		if (message!=null) {
			modelAndView.setViewName("display.jsp");

			modelAndView.addObject("message", "User Already Exist, Registration Unsuccessfull...");
			return modelAndView;
		} else {
			if (register.registrationValidate(user)) {
				modelAndView.setViewName("display.jsp");

				modelAndView.addObject("message", "Registration Successfull...");
				return modelAndView;
			} else {
				modelAndView.setViewName("display.jsp");

				modelAndView.addObject("message","Error in Registration..");
				return modelAndView;
			}
		}
		// String message=user.getEmail();
		}

	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
	
			ModelAndView modelAndView = new ModelAndView();
			user.setUserName(request.getParameter("name"));
			user.setPassword(request.getParameter("password"));
			return modelAndView;
		
		}

	public void ajaxEmailValidation() {

	}

	public void logout() {

	}
}
