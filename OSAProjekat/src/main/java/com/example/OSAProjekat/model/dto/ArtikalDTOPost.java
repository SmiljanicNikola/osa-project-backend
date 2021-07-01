package com.example.OSAProjekat.model.dto;

import java.io.Serializable;

public class ArtikalDTOPost implements Serializable {
	
	private Integer id;
	private String naziv;
	private String opis;
	private double cena;	
	private String putanjaSlike;
	private Integer prodavacId;
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
	public Integer getProdavacId() {
		return prodavacId;
	}
	public void setProdavacId(Integer prodavacId) {
		this.prodavacId = prodavacId;
	}
	
	

}
