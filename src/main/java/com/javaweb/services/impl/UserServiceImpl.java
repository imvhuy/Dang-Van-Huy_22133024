package com.javaweb.services.impl;

import com.javaweb.dao.UserDao;
import com.javaweb.dao.impl.UserDaoImpl;
import com.javaweb.models.UserModel;
import com.javaweb.services.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.get(username);
		if (user != null && password.equals(user.getPassWord())) {
			return user;
		}
		return null;
	}

	@Override
	public UserModel get(String username) {
		return userDao.get(username);
	}
}
