package com.javaweb.dao;

import com.javaweb.models.UserModel;

public interface UserDao {
	UserModel get(String username);
	void insert(UserModel user);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean checkExistPhone(String phone);
	boolean update(String username, String password);
}
