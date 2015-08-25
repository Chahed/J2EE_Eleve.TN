package com.chahed.spring.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.chahed.spring.dao.UserDAO;
import com.chahed.spring.dao.UserRoleDAO;
import com.chahed.spring.model.UserRole;

public class UserRoleServiceImpl implements UserRoleService{
	
	@Autowired
	private UserRoleDAO userRoleDAO ;
	
	@Override
	public void addUserRole(UserRole r) {
		this.userRoleDAO.addUserRole(r);
		
	}

	public UserRoleDAO getUserRoleDAO() {
		return userRoleDAO;
	}

	public void setUserRoleDAO(UserRoleDAO userRoleDAO) {
		this.userRoleDAO = userRoleDAO;
	}
}
