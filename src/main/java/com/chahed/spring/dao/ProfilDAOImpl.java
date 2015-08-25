package com.chahed.spring.dao;
 
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chahed.spring.model.Classe;
import com.chahed.spring.model.Profil;
 
@Repository
public class ProfilDAOImpl implements ProfilDAO {
     
    private static final Logger logger = LoggerFactory.getLogger(ProfilDAOImpl.class);
 
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @Override
    @Transactional
    public void addProfil(Profil p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Profil saved successfully, Profil Details="+p);
    }
 
    @Override
    @Transactional
    public void updateProfil(Profil p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Profil updated successfully, Profil Details="+p);
    }
 
	@Override
	@Transactional
	public List<Profil> listProfil() {
		   Session session = this.sessionFactory.getCurrentSession();
	        List<Profil> profilList = session.createQuery("from Profil").list();
	        System.out.println(profilList.get(0).getNom());
	        for(Profil c : profilList){
	            logger.info("Profil List::"+c);
	        }
	        return profilList;
	}
 
    @Override
    @Transactional
    public Profil getProfilById(int id) {
        Session session = this.sessionFactory.getCurrentSession();      
        Profil p = (Profil) session.load(Profil.class, new Integer(id));
        logger.info("Profil loaded successfully, Profil details="+p);
        return p;
    }
 
    @Override
    @Transactional
    public void removeProfil(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Profil p = (Profil) session.load(Profil.class, new Integer(id));
        if(null != p){
            session.delete(p);
        }
        logger.info("Profil deleted successfully, profil details="+p);
    }

	@Override
	@Transactional
	public List<Profil> ListProfilbyClasse(int id) {
		  Session session = this.sessionFactory.getCurrentSession();
	        List<Profil> personsList = session.createQuery("from Profil where id_classe="+id).list();
	        for(Profil p : personsList){
	            logger.info("Profil List::"+p);
	        }
	        return personsList;
		
	}
 
}