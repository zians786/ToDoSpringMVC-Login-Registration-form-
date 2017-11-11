
package com.bridgeit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bridgeit.model.User;

public class RegistrationDaoImp implements RegistrationDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	User user;

	public User user1=null;

	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public String emailValidaton() {

		return jdbcTemplate.query("select * from registration where email='" + user.getEmail() + "'",
				new ResultSetExtractor<String>() {
					public String extractData(ResultSet result) {
						String name=null;
						try {
							if (result.next()) {
								name="User Already Exist with this Email...";
							}
							else {
								String query="insert into registration values('"+user.getUserName()+"','"+user.getEmail()+"','"+user.getPassword()+"','"+user.getNumber()+"')";
								int queryResult=jdbcTemplate.update(query);
								if(queryResult>0) {
									name="Registration Successfull, Please Login...";	
								}
								else {
									name="Registration UnSuccessfull, Please Register Again...";
							   	}
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						return name;
					}
				});
	}

}
