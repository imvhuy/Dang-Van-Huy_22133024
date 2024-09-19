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

	@Override
	public void insert(UserModel user) {
		userDao.insert(user);
	}

	@Override
	public boolean register(String username, String password, String email, String fullname, String phone) {
		if (userDao.checkExistUsername(username)) {
			return false;
		}
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		userDao.insert(new UserModel(email, username, fullname, password, null, 1, phone, date));
		return true;
	}

	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}

	@Override
	public boolean update(String username, String password) {
		return userDao.update(username, password);
	}
}
