package com.chahed.spring.dao;

import java.util.List;

import com.chahed.spring.model.Users;

public interface UserDAO {
		
	    public void addUser(Users u);
	    public void updateUser(Users u );
	    public List<Users> listUser();
	    public void removeUser(int id);

	}

