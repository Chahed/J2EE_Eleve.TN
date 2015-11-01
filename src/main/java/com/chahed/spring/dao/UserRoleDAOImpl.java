package com.chahed.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chahed.spring.model.UserRole;
import com.chahed.spring.model.Users;

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
	
	
	@Override
	public List<Users> getUserbyRole(UserRole ur) {
		
		Session session = this.sessionFactory.openSession();
        List<Users> EnsList = session.createQuery("from user_roles u where u.username='ROLE_USER'").list();
        for(Users c : EnsList){
            logger.info("Ens List::"+c);
        }
        session.close();
        return EnsList;
	}

}
