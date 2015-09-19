package com.chahed.spring.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import com.sun.istack.internal.NotNull;

    @Entity
	@Table(name="PARENT")
	public class Parent {
	

		@Id
		@Column(name="id_parent")
		@GeneratedValue(strategy=GenerationType.AUTO)	
	    private int id;
		
	    private String nom;
	    private String prenom;

		  
	    private String email;
	    
	    private String login;
	    private String motdepasse;
	    private int tel;
	    
	    @ManyToMany
		@JoinTable(name="parent-profil"
			,joinColumns=@JoinColumn(name="id_parent")
			,inverseJoinColumns=@JoinColumn(name="id_profil"))
		 private List<Profil> gives ;
	  
	
	    
		

		public List<Profil> getGives() {
			return gives;
		}

		public void setGives(List<Profil> gives) {
			this.gives = gives;
		}

		public Parent() {
			super();
		}

		public Parent(String nom, String prenom, String email, String login, String motdepasse, int tel) {
			super();
			this.nom = nom;
			this.prenom = prenom;
			this.email = email;
			this.login = login;
			this.motdepasse = motdepasse;
			this.tel = tel;
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
	    
	    

		
	}


