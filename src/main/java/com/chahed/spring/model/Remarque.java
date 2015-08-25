package com.chahed.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="remarque")
public class Remarque {
	
	    @Id
	    @Column(name="id_rmq")
	    @GeneratedValue(strategy=GenerationType.AUTO)
		private int id ;
	    @Column
		private String text ;
	    
	    @ManyToOne
	    @JoinColumn(name="id_eleve")
	    private Profil profil ;

		public int getId() {
			return id;
		}

		public Remarque(String text, Profil profil) {
			super();
			this.text = text;
			this.profil = profil;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public Profil getProfil() {
			return profil;
		}

		public void setProfil(Profil profil) {
			this.profil = profil;
		}

		public Remarque(int id, String text, Profil profil) {
			super();
			this.id = id;
			this.text = text;
			this.profil = profil;
		}

		public Remarque() {
			super();
		}
	    
}
