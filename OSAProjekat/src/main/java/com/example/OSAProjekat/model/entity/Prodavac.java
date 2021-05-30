package com.example.OSAProjekat.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="prodavci")
public class Prodavac {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@OneToOne
	@JoinColumn(name = "prodavac_id", referencedColumnName = "korisnik_id", nullable = false)
	//@Column(name = "prodavac_id", referencedColumnName = "korisnik_id",unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "posluje_od", unique = false, nullable = true)
	private LocalDate poslujeOd;
	
	@Column(name = "email", unique = false, nullable = true)
	private String email;
	
	@Column(name = "adresa", unique = false, nullable = true)
	private String adresa;
	
	@Column(name = "naziv", unique = false, nullable = true)
	private String naziv;

	public Prodavac() {
		
	}
	
	
	public Prodavac(Integer id, LocalDate poslujeOd, String email, String adresa, String naziv) {
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
