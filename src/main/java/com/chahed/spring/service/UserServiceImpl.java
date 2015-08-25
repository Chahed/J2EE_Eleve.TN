package com.chahed.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.chahed.spring.dao.UserDAO;
import com.chahed.spring.model.Users;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO UserDAO ;

	public UserDAO getUserDAO() {
		return UserDAO;
	}

	public void setUserDAO(UserDAO UserDAO) {
		this.UserDAO = UserDAO;
	}

	@Override
	public void addUser(Users r) {
		this.UserDAO.addUser(r);
		
	}

	@Override
	public void updateUser(Users r) {
		this.UserDAO.updateUser(r);
		
	}

	@Override
	public List<Users> listUser() {
		return this.UserDAO.listUser();
	}



	@Override
	public void removeUser(int id) {
		this.UserDAO.removeUser(id);
		
	}



}
