package com.example.OSAProjekat.service;

import java.util.List;

import com.example.OSAProjekat.model.dto.ArtikalSearchRequestDTO;
import com.example.OSAProjekat.model.dto.ArtikalSearchResponseDTO;
import com.example.OSAProjekat.model.entity.ArtikalSearch;


public interface IArtikalService {

	void index(ArtikalSearchRequestDTO artikalSearchRequestDTO);
	
	List<ArtikalSearchResponseDTO> getArtikliByNaziv(String naziv);
	
	List<ArtikalSearch> getAll();
}
