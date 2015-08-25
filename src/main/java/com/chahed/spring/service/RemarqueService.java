package com.chahed.spring.service;

import java.util.List;

import com.chahed.spring.model.Remarque;

public interface RemarqueService {
	  public void addRemarque(Remarque r);
	    public void updateRemarque(Remarque r);
	    public List<Remarque> listRemarque();
	    public Remarque getRemarqueById(int id);
	    public void removeRemarque(int id);
	    public List<Remarque> ListRemarquebyEleve(int id);

}
