package com.chahed.spring.dao;

import java.util.List;

import com.chahed.spring.model.UserRole;
import com.chahed.spring.model.Users;

public interface UserRoleDAO {
	 public void addUserRole(UserRole u);
	 public List<Users> getUserbyRole(UserRole ur);

}
