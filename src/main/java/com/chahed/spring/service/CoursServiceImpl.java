package com.chahed.spring.service;



import java.util.List;

import com.chahed.spring.dao.CoursDAO;
import com.chahed.spring.model.Cours;


public class CoursServiceImpl implements CoursService{

	private CoursDAO coursDAO ;
	
	public void setCoursDAO(CoursDAO coursDAO) {
		this.coursDAO = coursDAO;
	}
	
	
	@Override
	public void addCours(Cours c) {
		 this.coursDAO.addCours(c); 
	}

	@Override
	public void updateCours(Cours c) {
		this.coursDAO.updateCours(c);
		
	}

	@Override
	public List<Cours> listCours() {
		return this.coursDAO.listCours();
	}

	@Override
	public Cours getCoursById(int id) {
	
		return this.coursDAO.getCoursById(id);
	}

	@Override
	public void removeCours(int id) {
		this.coursDAO.removeCours(id);
		
	}

}
