package com.example.OSAProjekat.model.dto;

import java.io.Serializable;

import javax.persistence.Column;

import com.example.OSAProjekat.model.entity.Artikal;


public class ArtikalDTO implements Serializable {

	private Integer id;
	
	private String naziv;
	
	private String opis;
	
	private double cena;	
	
	private String putanjaSlike;
	
	private ProdavacDTO prodavac;
	
	
	public ArtikalDTO() {
		
	}
	
	
	public ArtikalDTO(Artikal artikal) {
		this(artikal.getId(), artikal.getNaziv(), artikal.getOpis(), artikal.getCena(), artikal.getPutanjaSlike(),  new ProdavacDTO(artikal.getProdavac()));
	}

	
	public ArtikalDTO(Integer id, String naziv, String opis, double cena, String putanjaSlike, ProdavacDTO prodavac) {
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

	public ProdavacDTO getProdavac() {
		return prodavac;
	}

	public void setProdavac(ProdavacDTO prodavac) {
		this.prodavac = prodavac;
	}
		
	
}
