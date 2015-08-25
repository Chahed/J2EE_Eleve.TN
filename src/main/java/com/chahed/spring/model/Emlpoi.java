package com.chahed.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.internal.NotNull;

import sun.util.calendar.BaseCalendar.Date;


@Entity
@Table(name="EMPLOI")
public class Emlpoi {
    @Id
    @Column(name="id_emploi")
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id ;
	private int annee;
//	private Trimestre trimestre ;
//	private Jours jour ;
//	private Heures heure ;
	 @NotNull
	 @DateTimeFormat(pattern="dd/MM/yyyy")
	private Date date;
	
	
	

}
