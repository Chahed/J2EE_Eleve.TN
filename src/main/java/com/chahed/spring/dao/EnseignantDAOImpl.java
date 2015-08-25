package com.chahed.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chahed.spring.model.Cours;
import com.chahed.spring.model.Enseignant;



public class EnseignantDAOImpl implements EnseignantDAO{
	
	  
    private static final Logger logger = LoggerFactory.getLogger(EnseignantDAOImpl.class);
 
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @Transactional
	@Override
	public void addEnseignant(Enseignant e) {
		 Session session = this.sessionFactory.getCurrentSession();
	        session.persist(e);
	        logger.info("Enseignant  enregistré, Enseignant Details="+e);
		
	}
    @Transactional
	@Override
	public void updateEnseignant(Enseignant e) {
		Session session = this.sessionFactory.getCurrentSession();
        session.update(e);
        logger.info("enseignant mis à jour , Details="+e);
		
	}
    @Transactional
	@Override
	public List<Enseignant> listEnseignants() {
		 Session session = this.sessionFactory.getCurrentSession();
	        List<Enseignant> EnseignantList = session.createQuery("from Enseignant").list();
	        for(Enseignant e : EnseignantList){
	            logger.info("Enseignant List::"+e);
	        }
	        return EnseignantList;
	}
    @Transactional
	@Override
	public Enseignant getEnseignantById(int id) {
		Session session = this.sessionFactory.getCurrentSession();      
		Enseignant e = (Enseignant) session.load(Enseignant.class, new Integer(id));
        logger.info("Enseignant loaded successfully, Enseignant details="+e);
        return e;
	}
    @Transactional
	@Override
	public void removeEnseignant(int id) {
			Session session = this.sessionFactory.getCurrentSession();
			Enseignant e = (Enseignant) session.load(Enseignant.class, new Integer(id));
	        if(null != e){
	            session.delete(e);
	        }
	        logger.info("Enseignant deleted successfully,Enseignant details="+e);
		}

	@Override
	public List<Cours> getGives(int id) {

		Session session =  sessionFactory.getCurrentSession();
		Enseignant e = (Enseignant)session.load(Enseignant.class,id);
		return e.getGives();
	}



	
}