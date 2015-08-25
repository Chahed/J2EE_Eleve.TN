package com.chahed.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chahed.spring.model.Remarque;

import com.chahed.spring.model.Profil;

@Repository
public class RemarqueDAOImpl implements RemarqueDAO {
	
	   private static final Logger logger = LoggerFactory.getLogger(RemarqueDAOImpl.class);
	   
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
	@Override
	@Transactional
	public void addRemarque(Remarque c) {
		Session session = this.sessionFactory.getCurrentSession();
        session.persist(c);
		
	}
	 @Transactional
	@Override
	public void updateRemarque(Remarque c) {
		    Session session = this.sessionFactory.getCurrentSession();
	        session.update(c);
	        
		
	}
	 @Transactional
	@Override
	public List<Remarque> listRemarque() {
		   Session session = this.sessionFactory.openSession();
	        List<Remarque> RemarqueList = session.createQuery("from Remarque").list();
	        for(Remarque c : RemarqueList){
	            logger.info("Remarque List::"+c);
	        }
	        session.close();
	        return RemarqueList;
	}
	 @Transactional
	@Override
	public Remarque getRemarqueById(int id) {
		 Session session = this.sessionFactory.openSession();      
	        Remarque c = (Remarque) session.load(Remarque.class, new Integer(id));
	        session.close();
	        return c;
	}
	 @Transactional
	@Override
	public void removeRemarque(int id) {
		Session session = this.sessionFactory.openSession();
        Remarque c = (Remarque) session.load(Remarque.class, new Integer(id));
        if(null != c){
            session.delete(c);
        }
		session.close();
	}
    @Transactional
	@Override
	public List<Remarque> ListRemarquebyEleve(int id) {
		  Session session = this.sessionFactory.getCurrentSession();
	        List<Remarque> remarqueList = session.createQuery("from Remarque where id_eleve="+id).list();
	     
	        return remarqueList;
		
	}

}
