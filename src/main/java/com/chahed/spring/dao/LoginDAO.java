package com.chahed.spring.dao;

import com.chahed.spring.model.*;

public interface LoginDAO {
	
	Users findByUserName(String username);

}
