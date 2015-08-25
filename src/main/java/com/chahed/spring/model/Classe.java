package com.chahed.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/*to be pushed*/
@Entity
@Table(name="classe")
public class Classe {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id ;
    @Column
	private String nomclasse ;
	
	public Classe(int id) {
		super();
		this.id = id;
	}


	public Classe(String nomclasse) {
		super();
		this.nomclasse = nomclasse;
	}


	public Classe() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNomclasse() {
		return nomclasse;
	}


	public void setNomclasse(String nomclasse) {
		this.nomclasse = nomclasse;
	}
	
	

}
