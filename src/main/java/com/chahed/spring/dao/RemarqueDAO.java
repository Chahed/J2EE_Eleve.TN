package com.chahed.spring.dao;

import java.util.List;


import com.chahed.spring.model.Remarque;

public interface RemarqueDAO {
	  public void addRemarque(Remarque r);
	    public void updateRemarque(Remarque r);
	    public List<Remarque> listRemarque();
	    public Remarque getRemarqueById(int id);
	    public void removeRemarque(int id);
	    public List<Remarque> ListRemarquebyEleve(int id);

}
