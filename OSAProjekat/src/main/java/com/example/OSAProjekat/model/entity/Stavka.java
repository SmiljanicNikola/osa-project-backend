package com.example.OSAProjekat.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="stavke")
public class Stavka {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "stavka_id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "kolicina")
	private Integer kolicina;
	
	/*@OneToMany(mappedBy = "stavka",fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Stavka> stavke = new HashSet<>();*/
	@ManyToOne
	private Artikal artikal;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getKolicina() {
		return kolicina;
	}

	public void setKolicina(Integer kolicina) {
		this.kolicina = kolicina;
	}

	public Artikal getArtikal() {
		return artikal;
	}

	public void setArtikal(Artikal artikal) {
		this.artikal = artikal;
	}

	@Override
	public String toString() {
		return "Stavka [id=" + id + ", kolicina=" + kolicina + ", artikal=" + artikal + "]";
	}
	
	
}
