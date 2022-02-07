package com.example.OSAProjekat.model.dto;

public class ArtikalNazivRequestDTO {

	private String naziv;

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public ArtikalNazivRequestDTO(String naziv) {
		super();
		this.naziv = naziv;
	}

	public ArtikalNazivRequestDTO() {
		super();
	}
	
	
}
