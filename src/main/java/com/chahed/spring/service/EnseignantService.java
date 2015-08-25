package com.chahed.spring.service;

import java.util.List;

import com.chahed.spring.model.Cours;
import com.chahed.spring.model.Enseignant;


public interface EnseignantService {

	 public void addEnseignant(Enseignant e);
	   
	    public List<Enseignant > listEnseignants();
	    public Enseignant  getEnseignantById(int id);
	    public void removeEnseignant(int id);
		public void updateEnseignant(Enseignant e);
		public List<Cours> listGives(int id);
		
		public void addCoursToEnseignant(int enseignantId,int  coursId );


	   
}
