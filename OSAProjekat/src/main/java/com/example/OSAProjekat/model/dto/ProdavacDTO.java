package com.example.OSAProjekat.model.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import com.example.OSAProjekat.model.entity.Artikal;
import com.example.OSAProjekat.model.entity.Prodavac;

public class ProdavacDTO {

	private Integer id;
	@NotBlank
	private LocalDate poslujeOd;	
	@NotBlank
	private String email;
	@NotBlank
	private String adresa;
	@NotBlank
	private String naziv;

	
	private ProdavacDTO() {
		
	}

	public ProdavacDTO(Prodavac prodavac) {
		this(prodavac.getId(), prodavac.getPoslujeOd(), prodavac.getEmail(), prodavac.getAdresa(), prodavac.getNaziv());
	}
	
	public ProdavacDTO(Integer id, @NotBlank LocalDate poslujeOd, @NotBlank String email, @NotBlank String adresa,
			@NotBlank String naziv) {
		super();
		this.id = id;
		this.poslujeOd = poslujeOd;
		this.email = email;
		this.adresa = adresa;
		this.naziv = naziv;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public LocalDate getPoslujeOd() {
		return poslujeOd;
	}


	public void setPoslujeOd(LocalDate poslujeOd) {
		this.poslujeOd = poslujeOd;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAdresa() {
		return adresa;
	}


	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	
	
}
