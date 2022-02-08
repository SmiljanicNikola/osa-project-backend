package com.example.OSAProjekat.model.dto;

import java.time.LocalDate;

import com.example.OSAProjekat.model.entity.Kupac;

public class PorudzbinaSearchRequestDTO {
	
	private String id;

	private String satnica;
	
	private boolean dostavljeno;
	
	private int ocena;
	
	private String komentar;
	
	private boolean anonimanKomentar;
	
	private boolean arhiviranKomentar;

	private Kupac kupac;

	public String getSatnica() {
		return satnica;
	}


	public void setSatnica(String satnica) {
		this.satnica = satnica;
	}


	public boolean isDostavljeno() {
		return dostavljeno;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public PorudzbinaSearchRequestDTO() {
		super();
	}


	public PorudzbinaSearchRequestDTO(String id, String satnica, boolean dostavljeno, int ocena, String komentar,
			boolean anonimanKomentar, boolean arhiviranKomentar) {
		super();
		this.id = id;
		this.satnica = satnica;
		this.dostavljeno = dostavljeno;
		this.ocena = ocena;
		this.komentar = komentar;
		this.anonimanKomentar = anonimanKomentar;
		this.arhiviranKomentar = arhiviranKomentar;
	}


	public PorudzbinaSearchRequestDTO(String satnica, boolean dostavljeno, int ocena, String komentar,
			boolean anonimanKomentar, boolean arhiviranKomentar) {
		super();
		this.satnica = satnica;
		this.dostavljeno = dostavljeno;
		this.ocena = ocena;
		this.komentar = komentar;
		this.anonimanKomentar = anonimanKomentar;
		this.arhiviranKomentar = arhiviranKomentar;
	}


	public Kupac getKupac() {
		return kupac;
	}


	public void setKupac(Kupac kupac) {
		this.kupac = kupac;
	}


	public PorudzbinaSearchRequestDTO(String id, String satnica, boolean dostavljeno, int ocena, String komentar,
			boolean anonimanKomentar, boolean arhiviranKomentar, Kupac kupac) {
		super();
		this.id = id;
		this.satnica = satnica;
		this.dostavljeno = dostavljeno;
		this.ocena = ocena;
		this.komentar = komentar;
		this.anonimanKomentar = anonimanKomentar;
		this.arhiviranKomentar = arhiviranKomentar;
		this.kupac = kupac;
	}


	public PorudzbinaSearchRequestDTO(String satnica, boolean dostavljeno, int ocena, String komentar,
			boolean anonimanKomentar, boolean arhiviranKomentar, Kupac kupac) {
		super();
		this.satnica = satnica;
		this.dostavljeno = dostavljeno;
		this.ocena = ocena;
		this.komentar = komentar;
		this.anonimanKomentar = anonimanKomentar;
		this.arhiviranKomentar = arhiviranKomentar;
		this.kupac = kupac;
	}





	
	
}
