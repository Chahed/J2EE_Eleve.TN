package com.chahed.spring.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chahed.spring.model.Cours;


public class CoursDAOImpl  implements CoursDAO {

	  
    private static final Logger logger = LoggerFactory.getLogger(CoursDAOImpl.class);
 
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @Transactional
	@Override
	public void addCours(Cours c) {
		 Session session = this.sessionFactory.getCurrentSession();
	        session.persist(c);
	        logger.info(" cours enregistré, cours Details="+c);
		
	}
    @Transactional
	@Override
	public void updateCours(Cours c) {
		Session session = this.sessionFactory.getCurrentSession();
        session.update(c);
        logger.info("Cours mis à jour, Cours Details="+c);
		
	}
    @Transactional
	@Override
	public List<Cours> listCours() {
		 Session session = this.sessionFactory.getCurrentSession();
	        List<Cours> CoursList = session.createQuery("from Cours").list();
	        for(Cours c : CoursList){
	            logger.info("Cours List::"+c);
	        }
	        return CoursList;
	}
    @Transactional
	@Override
	public Cours getCoursById(int id) {
		Session session = this.sessionFactory.getCurrentSession();      
		Cours c = (Cours) session.load(Cours.class, new Integer(id));
        logger.info("Cours loaded successfully, Cours details="+c);
        return c;
	}
    @Transactional
	@Override
	public void removeCours(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Cours c = (Cours) session.load(Cours.class, new Integer(id));
        if(null != c){
            session.delete(c);
        }
        logger.info("Cours deleted successfully, Cours details="+c);
	}

}
