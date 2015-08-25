package com.chahed.spring.service;
 
import java.util.List;
 
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.chahed.spring.dao.ProfilDAO;
import com.chahed.spring.model.Profil;
 
@Service
public class ProfilServiceImpl implements ProfilService {
     
    private ProfilDAO ProfilDAO;
 
    public void setProfilDAO(ProfilDAO ProfilDAO) {
        this.ProfilDAO = ProfilDAO;
    }
 
    @Override
    @Transactional
    public void addProfil(Profil p) {
        this.ProfilDAO.addProfil(p);
    }
 
    @Override
    @Transactional
    public void updateProfil(Profil p) {
        this.ProfilDAO.updateProfil(p);
    }
 
    @Override
    @Transactional
    public List<Profil> listProfil() {
    	System.out.println("aaaaa");
        return this.ProfilDAO.listProfil();
    }
 
    @Override
    @Transactional
    public Profil getProfilById(int id) {
        return this.ProfilDAO.getProfilById(id);
    }
 
    @Override
    @Transactional
    public void removeProfil(int id) {
        this.ProfilDAO.removeProfil(id);
    }

	@Override
	public List<Profil> ListProfilbyClasse(int id) {
		return this.ProfilDAO.ListProfilbyClasse(id);
	}
 
}