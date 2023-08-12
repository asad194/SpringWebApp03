package com.example.demo.user.repository;

import com.example.demo.user.entity.User;

public interface UserDao {

	public User searchUser(Integer userId, String userPass);
	
}
