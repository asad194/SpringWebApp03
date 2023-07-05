package com.example.demo.user.repository;

import com.example.demo.user.entity.User;

public interface UserDao {

	public User searchUser(int userId, String userPass);
	
}
