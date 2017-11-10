package com.bridgeit.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bridgeit.model.User;

public class RegistrationDao {

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
					public String extractData(ResultSet rs) {

						try {
							if (rs.next()) {
								String name = rs.getString(2);
								return name;
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						return null;
					}
				});
	}

	public boolean registrationValidate(User user) {
		String query = "insert into registration values(?,?,?,?)";
		System.out.println("Inside 2 "+user.getUserName());
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
		
			public Boolean doInPreparedStatement(PreparedStatement statement) throws SQLException, DataAccessException {
//				statement.setString(1, user.getUserName());
//				System.out.println(user.getUserName());
//				statement.setString(2, user.getEmail());
//				statement.setString(3, user.getPassword());
//				statement.setLong(4, user.getNumber());

				return statement.execute();
			}
		});
	}

}
