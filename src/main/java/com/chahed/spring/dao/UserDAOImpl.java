package com.chahed.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chahed.spring.model.UserRole;
import com.chahed.spring.model.Users;

public class UserDAOImpl implements UserDAO{
	   private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	   
 private SessionFactory sessionFactory;
 
 public void setSessionFactory(SessionFactory sf){
     this.sessionFactory = sf;
 }
 
	@Override
	@Transactional
	public void addUser(Users c) {
		Session session = this.sessionFactory.getCurrentSession();
     session.persist(c);
		
	}

	@Override
	public void updateUser(Users c) {
		    Session session = this.sessionFactory.getCurrentSession();
	        session.update(c);
	        
		
	}

	@Override
	public List<Users> listUser() {
		   Session session = this.sessionFactory.openSession();
	        List<Users> UsersList = session.createQuery("from Users").list();
	        for(Users c : UsersList){
	            logger.info("Users List::"+c);
	        }
	        session.close();
	        return UsersList;
	}



	@Override
	public void removeUser(int id) {
		Session session = this.sessionFactory.openSession();
     Users c = (Users) session.load(Users.class, new Integer(id));
     if(null != c){
         session.delete(c);
     }
		session.close();
	}

	
}
