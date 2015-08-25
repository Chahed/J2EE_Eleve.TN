package com.chahed.spring.service;

import java.util.List;

import com.chahed.spring.model.Classe;

public interface ClasseService {
	
    public void addClasse(Classe c);
    public void updateClasse(Classe c );
    public List<Classe> listClasse();
    public Classe getClasseById(int id);
    public void removeClasse(int id);

}
