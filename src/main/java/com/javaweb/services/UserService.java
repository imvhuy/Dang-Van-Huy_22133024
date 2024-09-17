package com.javaweb.services;

import com.javaweb.models.UserModel;

public interface UserService {
	UserModel login(String username, String password);
	UserModel get(String username);
}
