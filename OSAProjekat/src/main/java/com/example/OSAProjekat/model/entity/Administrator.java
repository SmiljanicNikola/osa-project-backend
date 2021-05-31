package com.example.OSAProjekat.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="administratori")
public class Administrator {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "admin_id", unique = true, nullable = false)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "korisnik_id", referencedColumnName = "korisnik_id")
	private Korisnik korisnik;

	public Administrator() {
		
	}
	
	public Administrator(Integer id, Korisnik korisnik) {
		super();
		this.id = id;
		this.korisnik = korisnik;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	
	
	
	
	
}
