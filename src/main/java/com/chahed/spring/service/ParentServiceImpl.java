package com.chahed.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.chahed.spring.dao.CoursDAO;
import com.chahed.spring.dao.EnseignantDAO;
import com.chahed.spring.dao.ParentDAO;
import com.chahed.spring.dao.ProfilDAO;
import com.chahed.spring.model.Cours;
import com.chahed.spring.model.Parent;
import com.chahed.spring.model.Profil;

public class ParentServiceImpl implements ParentService{
	@Autowired
private ParentDAO parentDAO ;
private ProfilDAO profilDAO;



	
	
public void setParentDAO(ParentDAO parentDAO) {
	this.parentDAO = parentDAO;
}
	@Override
	@Transactional
	public void addParent(Parent p) {
		this.parentDAO.addParent(p);
		
	}

	@Override
	public List<Parent> listParent() {
	return	this.parentDAO.listParent();

	}

	@Override
	public Parent getParentById(int id) {
		return this.parentDAO.getParentById(id);
	}

	@Override
	public void removeParent(int id) {
		this.parentDAO.removeParent(id);
		
	}

	@Override
	public void updateParent(Parent p) {
		this.parentDAO.updateParent(p);
	}
	@Override
	public List<Profil> listProfil(int id) {
		return parentDAO.getProfils(id);
	}
	
	@Override
	public void addProfiltoParent(int parentId, int profilId) {
		Parent parent = parentDAO.getParentById(parentId);
		Profil profil = profilDAO.getProfilById(profilId);
		parent.getListProfil().add(profil);
		parentDAO.updateParent(parent);
		
	}

}
