package com.bridgeit.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bridgeit.model.User;

public class LoginDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	User user;
	
}
