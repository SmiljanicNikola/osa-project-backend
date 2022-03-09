package com.example.OSAProjekat.model.dto;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.example.OSAProjekat.model.entity.Korisnik;
import com.example.OSAProjekat.model.entity.Roles;

public class KorisnikDTO {


	private Integer id;
	
	@NotBlank
	private String ime;
	
	@NotBlank
	private String prezime;
	
	@NotBlank
	private String username;
	
	@NotBlank
	private String password;
	
	private boolean blokiran;
	
	
	public KorisnikDTO() {
		
	}
	
	public KorisnikDTO(Korisnik korisnik) {
		this(korisnik.getId(), korisnik.getIme(), korisnik.getPrezime(), korisnik.getUsername(), korisnik.getPassword(), korisnik.isBlokiran());
	}

	public KorisnikDTO(Integer id, String ime, String prezime, String username, String password, boolean blokiran) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.username = username;
		this.password = password;
		this.blokiran = blokiran;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isBlokiran() {
		return blokiran;
	}

	public void setBlokiran(boolean blokiran) {
		this.blokiran = blokiran;
	}
	
	
	
	
}
