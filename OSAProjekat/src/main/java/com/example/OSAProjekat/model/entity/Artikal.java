package com.example.OSAProjekat.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="artikli")
public class Artikal {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "naziv", unique = false, nullable = false)
	private String naziv;
	
	@Column(name = "opis", unique = false, nullable = false)
	private String opis;
	
	@Column(name = "cena", unique = false, nullable = false)
	private double cena;
	
	@Column(name = "putanja_slike", unique = false, nullable = false)
	private String putanjaSlike;
	
	@ManyToOne
	@JoinColumn(name = "prodavac_id", referencedColumnName = "prodavac_id")
	private Prodavac prodavac;
	
	
	public Artikal() {
		
	}
	
	public Artikal(Integer id, String naziv, String opis, double cena, String putanjaSlike) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.cena = cena;
		this.putanjaSlike = putanjaSlike;
	}

	
	

	public Artikal(Integer id, String naziv, String opis, double cena, String putanjaSlike, Prodavac prodavac) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.cena = cena;
		this.putanjaSlike = putanjaSlike;
		this.prodavac = prodavac;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public String getOpis() {
		return opis;
	}


	public void setOpis(String opis) {
		this.opis = opis;
	}


	public double getCena() {
		return cena;
	}


	public void setCena(double cena) {
		this.cena = cena;
	}


	public String getPutanjaSlike() {
		return putanjaSlike;
	}


	public void setPutanjaSlike(String putanjaSlike) {
		this.putanjaSlike = putanjaSlike;
	}

	public Prodavac getProdavac() {
		return prodavac;
	}

	public void setProdavac(Prodavac prodavac) {
		this.prodavac = prodavac;
	}
	
	
	
}
