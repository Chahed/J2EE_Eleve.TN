package com.chahed.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.chahed.spring.dao.ClasseDAO;

import com.chahed.spring.model.Classe;

public class ClasseServiceImpl implements ClasseService {
	@Autowired
	private ClasseDAO classeDAO;
	
    public void setClasseDAO(ClasseDAO classeDao) {
        this.classeDAO = classeDAO;
    }

	@Override
	public void addClasse(Classe c) {
		this.classeDAO.addClasse(c);
		
	}

	@Override
	public void updateClasse(Classe c) {
		this.classeDAO.updateClasse(c);
		
	}

	@Override
	public List<Classe> listClasse() {
		
		return this.classeDAO.listClasse();
	}

	@Override
	public Classe getClasseById(int id) {
		return this.classeDAO.getClasseById(id);
	}

	@Override
	public void removeClasse(int id) {
		this.classeDAO.removeClasse(id);
		
	}

}
