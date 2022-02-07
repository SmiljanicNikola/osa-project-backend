package com.example.OSAProjekat.model.dto;

import java.time.LocalDate;

public class PorudzbinaSearchResponseDTO {
	
	private String id;

	private String satnica;
	
	private boolean dostavljeno;
	
	private int ocena;
	
	private String komentar;
	
	private boolean anonimanKomentar;
	
	private boolean arhiviranKomentar;

	
	public String getSatnica() {
		return satnica;
	}

	public void setSatnica(String satnica) {
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isArhiviranKomentar() {
		return arhiviranKomentar;
	}

	public void setArhiviranKomentar(boolean arhiviranKomentar) {
		this.arhiviranKomentar = arhiviranKomentar;
	}

	
	public PorudzbinaSearchResponseDTO(String satnica, boolean dostavljeno, int ocena, String komentar,
			boolean anonimanKomentar, boolean arhiviranKomentar) {
		super();
		this.satnica = satnica;
		this.dostavljeno = dostavljeno;
		this.ocena = ocena;
		this.komentar = komentar;
		this.anonimanKomentar = anonimanKomentar;
		this.arhiviranKomentar = arhiviranKomentar;
	}

	public PorudzbinaSearchResponseDTO(String id, String satnica, boolean dostavljeno, int ocena, String komentar,
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

	public PorudzbinaSearchResponseDTO() {
		super();
	}


	
	
	
}
