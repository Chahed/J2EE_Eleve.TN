package com.chahed.spring.model;




import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;





@Entity
@Table(name="COURS")
public class Cours {
	 @Id
	 @Column(name="id_cours")
	 @GeneratedValue(strategy=GenerationType.AUTO)
	private int id ;
	 @Column
	private String libelle;
	 @ManyToMany
		@JoinTable(name="enseignant_cours"
			,joinColumns=@JoinColumn(name="id_cours")
			,inverseJoinColumns=@JoinColumn(name="id_enseignant"))
		 private List<Enseignant> givenBy ;
		
	

	public List<Enseignant> getGivenBy() {
		return givenBy;
	}


	public void setGivenBy(List<Enseignant> givenBy) {
		this.givenBy = givenBy;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	

}
