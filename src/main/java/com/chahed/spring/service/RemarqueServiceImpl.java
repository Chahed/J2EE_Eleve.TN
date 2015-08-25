package com.chahed.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.chahed.spring.dao.ClasseDAO;
import com.chahed.spring.dao.RemarqueDAO;
import com.chahed.spring.model.Remarque;

public class RemarqueServiceImpl implements RemarqueService {
	
	@Autowired
	private RemarqueDAO remarqueDAO ;

	public RemarqueDAO getRemarqueDAO() {
		return remarqueDAO;
	}

	public void setRemarqueDAO(RemarqueDAO remarqueDAO) {
		this.remarqueDAO = remarqueDAO;
	}

	@Override
	public void addRemarque(Remarque r) {
		this.remarqueDAO.addRemarque(r);
		
	}

	@Override
	public void updateRemarque(Remarque r) {
		this.remarqueDAO.updateRemarque(r);
		
	}

	@Override
	public List<Remarque> listRemarque() {
		return this.remarqueDAO.listRemarque();
	}

	@Override
	public Remarque getRemarqueById(int id) {
		return this.remarqueDAO.getRemarqueById(id);
	}

	@Override
	public void removeRemarque(int id) {
		this.remarqueDAO.removeRemarque(id);
		
	}

	@Override
	public List<Remarque> ListRemarquebyEleve(int id) {
		return this.remarqueDAO.ListRemarquebyEleve(id);
	}

}
