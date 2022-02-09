package com.example.OSAProjekat.model.entity;


import java.time.LocalDate;

import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

@Document(indexName="porudzbine7")
@Setting(settingPath= "/analyzers/serbianAnalyzer.json")
public class PorudzbinaSearch {

	@Id
	private String id;
	
	@Field(type = FieldType.Date, format=DateFormat.custom, pattern="yyyy-MM-dd")
	private LocalDate satnica;
	
	@Field(type = FieldType.Boolean)
	private boolean dostavljeno;
	
	@Field(type = FieldType.Integer)
	private int ocena;
	
	@Field(type = FieldType.Text)
	private String komentar;
	
	@Field(type = FieldType.Boolean)
	private boolean anonimanKomentar;
	
	@Field(type = FieldType.Boolean)
	private boolean arhiviranKomentar;
	
	@ManyToOne
	@Field(type = FieldType.Object)
	private Kupac kupac;
	
	@ManyToOne
	@Field(type = FieldType.Object)
	private Stavka stavka;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public LocalDate getSatnica() {
		return satnica;
	}

	public void setSatnica(LocalDate satnica) {
		this.satnica = satnica;
	}

	public boolean isDostavljeno() {
		return dostavljeno;
	}

	public void setDostavljeno(boolean dostavljeno) {
		this.dostavljeno = dostavljeno;
	}

	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public String getKomentar() {
		return komentar;
	}

	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}

	public boolean isAnonimanKomentar() {
		return anonimanKomentar;
	}

	public void setAnonimanKomentar(boolean anonimanKomentar) {
		this.anonimanKomentar = anonimanKomentar;
	}

	public boolean isArhiviranKomentar() {
		return arhiviranKomentar;
	}

	public void setArhiviranKomentar(boolean arhiviranKomentar) {
		this.arhiviranKomentar = arhiviranKomentar;
	}

	public Kupac getKupac() {
		return kupac;
	}

	public void setKupac(Kupac kupac) {
		this.kupac = kupac;
	}

	public Stavka getStavka() {
		return stavka;
	}

	public void setStavka(Stavka stavka) {
		this.stavka = stavka;
	}

	
	public PorudzbinaSearch(LocalDate satnica, boolean dostavljeno, int ocena, String komentar, boolean anonimanKomentar,
			boolean arhiviranKomentar) {
		super();
		this.satnica = satnica;
		this.dostavljeno = dostavljeno;
		this.ocena = ocena;
		this.komentar = komentar;
		this.anonimanKomentar = anonimanKomentar;
		this.arhiviranKomentar = arhiviranKomentar;
	}

	

	public PorudzbinaSearch(String id, LocalDate satnica, boolean dostavljeno, int ocena, String komentar,
			boolean anonimanKomentar, boolean arhiviranKomentar) {
		super();
		this.id = id;
		this.satnica = satnica;
		this.dostavljeno = dostavljeno;
		this.ocena = ocena;
		this.komentar = komentar;
		this.anonimanKomentar = anonimanKomentar;
		this.arhiviranKomentar = arhiviranKomentar;
	}

	public PorudzbinaSearch() {
		super();
	}

	
	
	
}
