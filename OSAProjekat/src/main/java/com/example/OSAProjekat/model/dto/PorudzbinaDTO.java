package com.example.OSAProjekat.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.example.OSAProjekat.model.entity.Porudzbina;

public class PorudzbinaDTO implements Serializable {

	private Integer id;
	private LocalDate satnica;
	private int ocena;
	private String komentar;
	private boolean anonimanKomentar;
	private boolean arhiviranKomentar;
	private KupacDTO kupac;
	private StavkaDTO stavka;
	
	public PorudzbinaDTO() {
		
	}
	
	public PorudzbinaDTO(Porudzbina porudzbina) {
		this(porudzbina.getId(), porudzbina.getSatnica(), porudzbina.getOcena(), porudzbina.getKomentar(), porudzbina.isAnonimanKomentar(), porudzbina.isArhiviranKomentar(), new KupacDTO(porudzbina.getKupac()), new StavkaDTO(porudzbina.getStavka()));
	}

	public PorudzbinaDTO(Integer id, LocalDate satnica, int ocena, String komentar, boolean anonimanKomentar,
			boolean arhiviranKomentar, KupacDTO kupac, StavkaDTO stavka) {
		super();
		this.id = id;
		this.satnica = satnica;
		this.ocena = ocena;
		this.komentar = komentar;
		this.anonimanKomentar = anonimanKomentar;
		this.arhiviranKomentar = arhiviranKomentar;
		this.kupac = kupac;
		this.stavka = stavka;
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

	public KupacDTO getKupac() {
		return kupac;
	}

	public void setKupac(KupacDTO kupac) {
		this.kupac = kupac;
	}

	public StavkaDTO getStavka() {
		return stavka;
	}

	public void setStavka(StavkaDTO stavka) {
		this.stavka = stavka;
	}
	
	
	
}
