package com.example.OSAProjekat.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

@Document(indexName="artikli7")
@Setting(settingPath= "/analyzers/serbianAnalyzer.json")
public class ArtikalSearch {
	
	@Id
	private String id;
	
	@Field(type = FieldType.Text)
	private String naziv;
	
	@Field(type = FieldType.Text)
	private String opis;
	
	@Field(type = FieldType.Double)
	private double cena;
	
	@Field(type = FieldType.Keyword)
	private String putanjaSlike;
	
	@Field(type=FieldType.Integer)
	private int prodavacId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
	

	public int getProdavacId() {
		return prodavacId;
	}

	public void setProdavacId(int prodavacId) {
		this.prodavacId = prodavacId;
	}

	public ArtikalSearch(String id, String naziv, String opis, double cena, String putanjaSlike) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.cena = cena;
		this.putanjaSlike = putanjaSlike;
	}

	public ArtikalSearch() {
		super();
	}

	public ArtikalSearch(String naziv, String opis, double cena, String putanjaSlike) {
		super();
		this.naziv = naziv;
		this.opis = opis;
		this.cena = cena;
		this.putanjaSlike = putanjaSlike;
	}

	public ArtikalSearch(String id, String naziv, String opis, double cena, String putanjaSlike, int prodavacId) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.cena = cena;
		this.putanjaSlike = putanjaSlike;
		this.prodavacId = prodavacId;
	}

	public ArtikalSearch(String naziv, String opis, double cena, String putanjaSlike, int prodavacId) {
		super();
		this.naziv = naziv;
		this.opis = opis;
		this.cena = cena;
		this.putanjaSlike = putanjaSlike;
		this.prodavacId = prodavacId;
	}
	
	
	

}
