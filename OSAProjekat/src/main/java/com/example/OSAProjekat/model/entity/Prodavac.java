package com.example.OSAProjekat.model.entity;

import static javax.persistence.CascadeType.ALL;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="prodavci")
public class Prodavac {

	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OneToOne
	@JoinColumn(name = "prodavac_id", referencedColumnName = "korisnik_id", nullable = false)
	//@Column(name = "prodavac_id", referencedColumnName = "korisnik_id",unique = true, nullable = false)
	private Integer id;*/
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "prodavac_id", unique = true, nullable = false)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "korisnik_id", referencedColumnName = "korisnik_id")
	private Korisnik korisnik;
	
	@Column(name = "posluje_od", unique = false, nullable = true)
	private LocalDate poslujeOd;
	
	@Column(name = "email", unique = false, nullable = true)
	private String email;
	
	@Column(name = "adresa", unique = false, nullable = true)
	private String adresa;
	
	@Column(name = "naziv", unique = false, nullable = true)
	private String naziv;
	
	@OneToMany(cascade= {ALL}, mappedBy= "prodavac",fetch = FetchType.EAGER)
    private Set<Artikal> artikli = new HashSet<Artikal>();

	public Prodavac() {
		
	}
	
	
	

	public Prodavac(LocalDate poslujeOd, String email, String adresa, String naziv) {
		super();
		this.poslujeOd = poslujeOd;
		this.email = email;
		this.adresa = adresa;
		this.naziv = naziv;
	}




	public Prodavac(Integer id, Korisnik korisnik, LocalDate poslujeOd, String email, String adresa, String naziv) {
		super();
		this.id = id;
		this.korisnik = korisnik;
		this.poslujeOd = poslujeOd;
		this.email = email;
		this.adresa = adresa;
		this.naziv = naziv;
	}




	public Korisnik getKorisnik() {
		return korisnik;
	}




	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
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
