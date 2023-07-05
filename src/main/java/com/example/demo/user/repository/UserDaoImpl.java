package com.example.demo.user.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.user.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public UserDaoImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public User searchUser(int userId, String userPass) {
		//String sql = "SELECT user_name FROM `user` WHERE user_id = ? AND user_pass = ?";
		String sql = "SELECT user_name FROM `user` WHERE user_id = ? AND user_pass = ?";
		/*
		DataSource dataSource = jdbcTemplate.getDataSource();
		if(dataSource != null) {
			System.out.println("Datasourceが設定されています");
		} else {
			System.out.println("Datasourceが設定されていません");
		}
		*/
		List<Map<String, Object>> result = jdbcTemplate.queryForList(sql, userId, userPass);

		if(result.isEmpty()) {
			User noHitUser = new User();
			noHitUser.setUserId(null);
			noHitUser.setUserName(null);
			noHitUser.setUserPass(null);
			return noHitUser;
		}
		List<User> userList = new ArrayList<User>();
		for(Map<String, Object> rr : result) {
			User hitUser = new User();
			hitUser.setUserId((Integer)rr.get("user_id"));
			hitUser.setUserName((String)rr.get("user_name"));
			hitUser.setUserPass((String)rr.get("user_pass"));
			userList.add(hitUser);
		}
		User loginUser = null;
		if(!userList.isEmpty()) {
			loginUser = userList.get(0);
		}
		return loginUser;
	}
	



}
