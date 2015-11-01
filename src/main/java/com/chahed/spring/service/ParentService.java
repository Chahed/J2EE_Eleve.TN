package com.chahed.spring.service;

import java.util.List;

import com.chahed.spring.model.Parent;
import com.chahed.spring.model.Profil;



public interface ParentService {
	 public void addParent(Parent p);
	   
	    public List<Parent > listParent();
	    public Parent  getParentById(int id);
	    public void removeParent(int id);
		public void updateParent(Parent p);
		public List<Profil> listGives(int id);
		
		public void addProfilToParent(int parentId, int profilId);
}
