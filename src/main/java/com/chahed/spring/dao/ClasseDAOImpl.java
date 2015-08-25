package com.chahed.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chahed.spring.model.Classe;

@Repository
public class ClasseDAOImpl implements ClasseDAO {
	
	   private static final Logger logger = LoggerFactory.getLogger(ClasseDAOImpl.class);
	   
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
	@Override
	@Transactional
	public void addClasse(Classe c) {
		Session session = this.sessionFactory.getCurrentSession();
        session.persist(c);
		
	}

	@Override
	public void updateClasse(Classe c) {
		    Session session = this.sessionFactory.getCurrentSession();
	        session.update(c);
	        
		
	}

	@Override
	public List<Classe> listClasse() {
		   Session session = this.sessionFactory.openSession();
	        List<Classe> classeList = session.createQuery("from Classe").list();
	        for(Classe c : classeList){
	            logger.info("Classe List::"+c);
	        }
	        session.close();
	        return classeList;
	}

	@Override
	public Classe getClasseById(int id) {
		 Session session = this.sessionFactory.openSession();      
	        Classe c = (Classe) session.load(Classe.class, new Integer(id));
	        session.close();
	        return c;
	}

	@Override
	public void removeClasse(int id) {
		Session session = this.sessionFactory.openSession();
        Classe c = (Classe) session.load(Classe.class, new Integer(id));
        if(null != c){
            session.delete(c);
        }
		session.close();
	}

}
