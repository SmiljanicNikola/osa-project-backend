package com.example.OSAProjekat.model.dto;

import javax.validation.constraints.NotBlank;

import com.example.OSAProjekat.model.entity.Administrator;
import com.example.OSAProjekat.model.entity.Prodavac;

public class AdministratorDTO {

	private Integer id;
	
	@NotBlank
	private KorisnikDTO korisnik;
	
	public AdministratorDTO() {
		
	}

	public AdministratorDTO(Integer id, @NotBlank KorisnikDTO korisnik) {
		super();
		this.id = id;
		this.korisnik = korisnik;
	}
	
	public AdministratorDTO(Administrator administrator) {
		this(administrator.getId(), new KorisnikDTO(administrator.getKorisnik()));
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public KorisnikDTO getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(KorisnikDTO korisnik) {
		this.korisnik = korisnik;
	}
	
}
