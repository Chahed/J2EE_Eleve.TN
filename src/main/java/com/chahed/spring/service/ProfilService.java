package com.chahed.spring.service;

import java.util.List;

import com.chahed.spring.model.Profil;

public interface ProfilService {
    public void addProfil(Profil p);
    public void updateProfil(Profil p);
    public List<Profil> listProfil();
    public Profil getProfilById(int id);
    public void removeProfil(int id);
    public List<Profil> ListProfilbyClasse(int id);

}
