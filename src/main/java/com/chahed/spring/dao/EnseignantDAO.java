package com.chahed.spring.dao;
import java.util.List;

import com.chahed.spring.model.*;
public interface EnseignantDAO {
	
	    public void addEnseignant(Enseignant e);
	    public List<Enseignant > listEnseignants();
	    public Enseignant  getEnseignantById(int id);
	    public void removeEnseignant(int id);
		public void updateEnseignant(Enseignant e);
        public List<Cours> getGives(int id);

	

}