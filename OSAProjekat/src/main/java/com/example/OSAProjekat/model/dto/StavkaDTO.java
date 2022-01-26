package com.example.OSAProjekat.model.dto;

import java.io.Serializable;

import com.example.OSAProjekat.model.entity.Stavka;

public class StavkaDTO implements Serializable {
	
	private Integer id;
	private Integer kolicina;
	private ArtikalDTO artikal;
	
	public StavkaDTO() {
		super();
	}

	public StavkaDTO(Stavka stavka) {
		this(stavka.getId(), stavka.getKolicina(), new ArtikalDTO(stavka.getArtikal()));
	}
	
	
	public StavkaDTO(Integer id, Integer kolicina, ArtikalDTO artikal) {
		super();
		this.id = id;
		this.kolicina = kolicina;
		this.artikal = artikal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getKolicina() {
		return kolicina;
	}

	public void setKolicina(Integer kolicina) {
		this.kolicina = kolicina;
	}

	public ArtikalDTO getArtikal() {
		return artikal;
	}

	public void setArtikal(ArtikalDTO artikal) {
		this.artikal = artikal;
	}

	
	

}
