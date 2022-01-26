package com.example.OSAProjekat.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "porudzbine")
public class Porudzbina {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
	
	
	@Column(name = "satnica")
	private LocalDate satnica;
	
	@Column(name = "dostavljeno")
	private boolean dostavljeno;
	
	@Column(name = "ocena")
	private int ocena;
	
	@Column(name = "komentar")
	private String komentar;
	
	@Column(name = "anoniman_komentar")
	private boolean anonimanKomentar;
	
	@Column(name = "arhiviran_komentar")
	private boolean arhiviranKomentar;
	
	@ManyToOne
	@JoinColumn(name="kupac_id", referencedColumnName="kupac_id")
	private Kupac kupac;
	
	@ManyToOne
	@JoinColumn(name="stavka_id", referencedColumnName="stavka_id")
	private Stavka stavka;

	
	
	
	
	public Porudzbina() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	

	public LocalDate getSatnica() {
		return satnica;
	}

	public void setSatnica(LocalDate satnica) {
		this.satnica = satnica;
	}

	public boolean isDostavljeno() {
		return dostavljeno;
	}

	public void setDostavljeno(boolean dostavljeno) {
		this.dostavljeno = dostavljeno;
	}

	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public String getKomentar() {
		return komentar;
	}

	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}

	public boolean isAnonimanKomentar() {
		return anonimanKomentar;
	}

	public void setAnonimanKomentar(boolean anonimanKomentar) {
		this.anonimanKomentar = anonimanKomentar;
	}

	public boolean isArhiviranKomentar() {
		return arhiviranKomentar;
	}

	public void setArhiviranKomentar(boolean arhiviranKomentar) {
		this.arhiviranKomentar = arhiviranKomentar;
	}

	public Kupac getKupac() {
		return kupac;
	}

	public void setKupac(Kupac kupac) {
		this.kupac = kupac;
	}

	public Stavka getStavka() {
		return stavka;
	}

	public void setStavka(Stavka stavka) {
		this.stavka = stavka;
	}

	@Override
	public String toString() {
		return "Porudzbina [id=" + id + ", satnica=" + satnica + ", dostavljeno=" + dostavljeno + ", ocena=" + ocena
				+ ", komentar=" + komentar + ", anonimanKomentar=" + anonimanKomentar + ", arhiviranKomentar="
				+ arhiviranKomentar + ", kupac=" + kupac + ", stavka=" + stavka + "]";
	}

	
	
	
	
}
