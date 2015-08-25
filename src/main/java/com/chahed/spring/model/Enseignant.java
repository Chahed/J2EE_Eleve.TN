package com.chahed.spring.model;



import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="ENSEIGNANT")
public class Enseignant  {
	
	@Id
	@Column(name="id_enseignant")
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int id;
	@Column
    private String nom;
	@Column
    private String prenom;
	@Column
    private String email;
	@Column
    private String login;
	@Column
    private String motdepasse;
	@Column
    private int tel;
	@Column
	private String specialite ;
	
//	@ManyToOne
//	@JoinColumn(name="id_classe")
//	private Classe classe;
	 
	@ManyToMany
	@JoinTable(name="enseignant_cours"
		,joinColumns=@JoinColumn(name="id_enseignant")
		,inverseJoinColumns=@JoinColumn(name="id_cours"))
	private List<Cours> gives;

 
	
	public String getSpecialite() {
		return specialite;
	}

	
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotdepasse() {
		return motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}


	public List<Cours> getGives() {
		return gives;
	}


	public void setGives(List<Cours> gives) {
		this.gives = gives;
	}



	
	
	
	


}
