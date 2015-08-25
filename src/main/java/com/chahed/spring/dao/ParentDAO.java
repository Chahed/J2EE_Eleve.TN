package com.chahed.spring.dao;

import java.util.List;

import com.chahed.spring.model.Parent;
import com.chahed.spring.model.Profil;



public interface ParentDAO {
	 public void addParent(Parent p);
	    public List<Parent > listParent();
	    public Parent  getParentById(int id);
	    public void removeParent(int id);
		public void updateParent(Parent p);
		public List<Profil> getProfils(int id);
	
}
