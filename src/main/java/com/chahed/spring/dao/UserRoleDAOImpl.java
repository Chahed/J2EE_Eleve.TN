package com.chahed.spring.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chahed.spring.model.UserRole;

public class UserRoleDAOImpl implements UserRoleDAO {
	   private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	   
private SessionFactory sessionFactory;

public void setSessionFactory(SessionFactory sf){
  this.sessionFactory = sf;
}

	@Override
	@Transactional
	public void addUserRole(UserRole c) {
		Session session = this.sessionFactory.getCurrentSession();
  session.persist(c);
		
	}
}
