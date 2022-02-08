package com.example.OSAProjekat.service;

import java.util.List;

import com.example.OSAProjekat.model.dto.ArtikalSearchRequestDTO;
import com.example.OSAProjekat.model.dto.ArtikalSearchResponseDTO;
import com.example.OSAProjekat.model.entity.ArtikalSearch;


public interface IArtikalService {

	void index(ArtikalSearchRequestDTO artikalSearchRequestDTO);
	
	List<ArtikalSearchResponseDTO> getArtikliByNaziv(String naziv);
	
	List<ArtikalSearch> getAll();
	
	List<ArtikalSearchResponseDTO> getArtikliByCenaGreaterThan(int cena);
	
	List<ArtikalSearchResponseDTO> getArtikliByCenaLessThan(int cena);
	
	List<ArtikalSearchResponseDTO> getArtikliByCenaGreatherThanAndLessThan(double minCena, int maxCena);
}
