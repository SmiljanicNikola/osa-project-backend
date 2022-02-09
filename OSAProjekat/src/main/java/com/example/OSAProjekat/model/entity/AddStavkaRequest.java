package com.example.OSAProjekat.model.entity;

import java.io.Serializable;

public class AddStavkaRequest implements Serializable{

	private Integer kolicina;
	private Integer artikalId;
	
	
	public Integer getKolicina() {
		return kolicina;
	}
	public void setKolicina(Integer kolicina) {
		this.kolicina = kolicina;
	}
	public Integer getArtikalId() {
		return artikalId;
	}
	public void setArtikalId(Integer artikalId) {
		this.artikalId = artikalId;
	}
	
	public AddStavkaRequest(Integer kolicina, Integer artikalId) {
		super();
		this.kolicina = kolicina;
		this.artikalId = artikalId;
	}
	public AddStavkaRequest() {
		super();
	}
	
	
}
