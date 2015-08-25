package com.chahed.spring.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;



@Entity
@Table(name="profil")
public class Profil {
 
 @Id
 @Column(name="id_profil")
 @GeneratedValue(strategy=GenerationType.AUTO) 
 private int id ;
 
 private String nom ;
 private String prenom ;
 private Date dateNaissance  ;
 

 @ManyToOne
 @JoinColumn(name="id_classe")
 private Classe classe ;
 
 @ManyToMany
	@JoinTable(name="parent-profil"
		,joinColumns=@JoinColumn(name="id_profil")
		,inverseJoinColumns=@JoinColumn(name="id_parent"))
	 private List<Parent> ListParent ;

 public List<Parent> getListParent() {
	return ListParent;
}

public void setListParent(List<Parent> listParent) {
	ListParent = listParent;
}

public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 public Profil(int id, String nom, String prenom, Date dateNaissance, Classe classe) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
	this.dateNaissance = dateNaissance;
	this.classe = classe;
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

 public Date getDateNaissance() {
  return dateNaissance;
 }

 public void setDateNaissance(Date dateNaissance) {
  this.dateNaissance = dateNaissance;
 }

 public Classe getClasse() {
  return classe;
 }

 public Profil() {
	super();
}

public void setClasse(Classe classe) {
  this.classe = classe;
 }

public void setIdClasse(int id){
	this.classe.setId(id);
}
// public Set<Remarque> getRemarques() {
//  return remarques;
// }
//
// public void setRemarques(Set<Remarque> remarques) {
//  this.remarques = remarques;
// }

 public Profil(String nom, String prenom, Date dateNaissance, Classe classe /*,Set<Remarque> remarques*/) {
  super();
  this.nom = nom;
  this.prenom = prenom;
  this.dateNaissance = dateNaissance;
  this.classe = classe;
//  this.remarques = remarques;
 }
 
 
 }