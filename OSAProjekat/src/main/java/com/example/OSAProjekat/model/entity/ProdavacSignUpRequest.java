package com.example.OSAProjekat.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;

public class ProdavacSignUpRequest {
	
	private String ime;
	
	private String prezime;
	
	private String username;
	
	private String password;
	
	private boolean blokiran;
	
    private Roles role;
	
	private LocalDate poslujeOd;
	
	private String email;
	
	private String adresa;
	
	private String naziv;

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

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}
	
	
	

}
