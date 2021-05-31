package com.example.OSAProjekat.model.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.example.OSAProjekat.model.entity.Korisnik;
import com.example.OSAProjekat.model.entity.Kupac;
import com.example.OSAProjekat.model.entity.Prodavac;

public class KupacDTO {

	
	private Integer id;
	
	private KorisnikDTO korisnik;
	
	private String adresa;
	
	
	public KupacDTO() {
		
	}

	public KupacDTO(Kupac kupac) {
		this(kupac.getId(), new KorisnikDTO(kupac.getKorisnik()), kupac.getAdresa());
	}
	
	public KupacDTO(Integer id, KorisnikDTO korisnik, String adresa) {
		super();
		this.id = id;
		this.korisnik = korisnik;
		this.adresa = adresa;
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


	public String getAdresa() {
		return adresa;
	}


	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
	
	
	
}
