package com.example.OSAProjekat.service;

import java.util.List;
import java.util.Optional;

import com.example.OSAProjekat.model.dto.PorudzbinaSearchRequestDTO;
import com.example.OSAProjekat.model.dto.PorudzbinaSearchResponseDTO;
import com.example.OSAProjekat.model.dto.PorudzbinaSearchResponseDTO2;
import com.example.OSAProjekat.model.entity.ArtikalSearch;
import com.example.OSAProjekat.model.entity.PorudzbinaSearch;

public interface IPorudzbinaService {

	void index(PorudzbinaSearchRequestDTO porudzbinaSearchRequestDTO);
	
	List<PorudzbinaSearchResponseDTO> getPorudzbineByKomentar(String komentar);
	
	List<PorudzbinaSearchResponseDTO> getAll();
	
	List<PorudzbinaSearchResponseDTO> getPorudzbineByOcenaGreaterThanAndLessThan(int minOcena,int maxOcena);
	
	List<PorudzbinaSearchResponseDTO> getAllByKupacId(int id);
	
	PorudzbinaSearch save(PorudzbinaSearchRequestDTO porudzbinaSearchRequestDTO);
	
	Optional<PorudzbinaSearch> findById(String id);


}
