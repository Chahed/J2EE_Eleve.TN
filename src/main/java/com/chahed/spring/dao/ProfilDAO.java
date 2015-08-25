package com.chahed.spring.dao;

import java.util.List;

import com.chahed.spring.model.Profil;

public interface ProfilDAO {
    public void addProfil(Profil p);
    public void updateProfil(Profil p);
    public List<Profil> listProfil();
    public Profil getProfilById(int id);
    public void removeProfil(int id);
    public List<Profil> ListProfilbyClasse(int id);
}
