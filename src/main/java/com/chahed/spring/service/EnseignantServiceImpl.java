package com.chahed.spring.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.chahed.spring.dao.CoursDAO;
import com.chahed.spring.dao.EnseignantDAO;
import com.chahed.spring.model.Cours;
import com.chahed.spring.model.Enseignant;



public class EnseignantServiceImpl implements  EnseignantService{
	@Autowired
private EnseignantDAO enseignantDAO ;
	@Autowired
private CoursDAO coursDAO;


	
	
public void setEnseignantDAO(EnseignantDAO enseignantDAO) {
	this.enseignantDAO = enseignantDAO;
}

	@Override
	@Transactional
	public void addEnseignant(Enseignant e) {
		this.enseignantDAO.addEnseignant(e);
	}

	@Override
	@Transactional
	public void updateEnseignant(Enseignant e) {
	this.enseignantDAO.updateEnseignant(e);
		
	}

	@Override
	@Transactional
	public List<Enseignant> listEnseignants() {
		
		return this.enseignantDAO.listEnseignants();
	}

	@Override
	@Transactional
	public Enseignant getEnseignantById(int id) {
		
		return this.enseignantDAO.getEnseignantById(id);
	}

	@Override
	@Transactional
	public void removeEnseignant(int id) {
		this.enseignantDAO.removeEnseignant(id);
		
	}

	@Override
	@Transactional
	public List<Cours> listGives(int id) {
		enseignantDAO.getGives(id).size();
		return enseignantDAO.getGives(id);
	}

	@Override
	@Transactional
	public void addCoursToEnseignant(int enseignantId, int coursId) {
		Enseignant enseignant = enseignantDAO.getEnseignantById(enseignantId);
		Cours cours = coursDAO.getCoursById(coursId);
		enseignant.getGives().add(cours);
		enseignantDAO.updateEnseignant(enseignant);
		
	}
	
}
