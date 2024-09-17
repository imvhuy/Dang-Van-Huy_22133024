package com.javaweb.dao;

import com.javaweb.models.UserModel;

public interface UserDao {
	UserModel get(String username);
}
