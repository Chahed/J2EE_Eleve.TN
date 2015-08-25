package com.chahed.spring.service;



import java.util.List;

import com.chahed.spring.model.Cours;


public interface CoursService {

		    public void addCours(Cours c);
		    public void updateCours(Cours c);
		    public List<Cours> listCours();
		    public Cours getCoursById(int id);
		    public void removeCours(int id);
}
