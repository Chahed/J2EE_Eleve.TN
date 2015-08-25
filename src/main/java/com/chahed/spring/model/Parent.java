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

import org.springmodules.validation.bean.conf.loader.annotation.handler.Email;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotEmpty;
import org.springmodules.validation.bean.conf.loader.annotation.handler.Size;

import com.sun.istack.internal.NotNull;

    @Entity
	@Table(name="PARENT")
	public class Parent {
	

		@Id
		@Column(name="id_parent")
		@GeneratedValue(strategy=GenerationType.AUTO)	
	    private int id;
		@NotEmpty(message = "Please enter your name")
	    @Size(min = 1, max = 12)
	    private String nom;
		@NotEmpty
	    @Size(min = 1, max = 12 , message = "Your lastname must between 1 and 12 characters")
	    private String prenom;
		  @NotEmpty(message = "Please enter your email addresss.") @Email
		  @Size(min = 3, max = 10 , message = "Your password must between 3 and 10 characters")
	    private String email;
	    @NotEmpty
	    @Column(name = "login", unique=true, nullable = false)
	    private String login;
	    private String motdepasse;
	    private int tel;
	    
	    @ManyToMany
		@JoinTable(name="parent-profil"
			,joinColumns=@JoinColumn(name="id_parent")
			,inverseJoinColumns=@JoinColumn(name="id_profil"))
		 private List<Profil> ListProfil ;
	  
		
		public List<Profil> getListProfil() {
			return ListProfil;
		}

		public void setListProfil(List<Profil> listProfil) {
			ListProfil = listProfil;
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


