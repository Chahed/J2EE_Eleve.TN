package com.chahed.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chahed.spring.model.Enseignant;
import com.chahed.spring.model.Parent;
import com.chahed.spring.model.Profil;

public class ParentDAOImpl implements ParentDAO {

	
	 private static final Logger logger = LoggerFactory.getLogger(ParentDAOImpl.class);
	 
	    private SessionFactory sessionFactory;
	     
	    public void setSessionFactory(SessionFactory sf){
	        this.sessionFactory = sf;
	    }
	
	
	@Transactional
	@Override
	public void addParent(Parent p) {
		 Session session = this.sessionFactory.getCurrentSession();
	        session.persist(p);
	        logger.info("Parent  enregistré, Parent Details="+p);
	}

	@Override
	@Transactional
	public List<Parent> listParent() {
		Session session = this.sessionFactory.getCurrentSession();
        List<Parent> ParentList = session.createQuery("from Parent").list();
        for(Parent p : ParentList){
            logger.info("Parent List::"+p);
        }
        return ParentList;
	}

	@Override
	@Transactional
	public Parent getParentById(int id) {
		Session session = this.sessionFactory.getCurrentSession();      
		Parent p = (Parent) session.load(Parent.class, new Integer(id));
        logger.info("Parent loaded successfully, Parent details="+p);
        return p;
	}

	@Override
	@Transactional
	public void removeParent(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Parent p = (Parent) session.load(Parent.class, new Integer(id));
        if(null != p){
            session.delete(p);
        }
        logger.info("Parent deleted successfully,Parent details="+p);
		
	}

	@Override
	@Transactional
	public void updateParent(Parent p) {
		Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Parent mis à jour , Details="+p);
	}


	@Override
	@Transactional
	public List<Profil> getProfils(int id) {
		Session session =  sessionFactory.getCurrentSession();
		Parent e = (Parent)session.load(Parent.class,id);
		return e.getListProfil();
	}

}
