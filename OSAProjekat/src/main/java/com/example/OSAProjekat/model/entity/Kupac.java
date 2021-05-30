/*package com.example.OSAProjekat.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="kupci")
public class Kupac {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OneToOne
	@JoinColumn(name = "korisnik_id", referencedColumnName = "korisnik_id", nullable = false)
	private Integer id;
	
	@Column(name = "adresa", unique = false, nullable = false)
	private String adresa;
	
	public Kupac() {
		
	}

	public Kupac(Integer id, String adresa) {
		super();
		this.id = id;
		this.adresa = adresa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
	
	
	
	
	
	
}*/
