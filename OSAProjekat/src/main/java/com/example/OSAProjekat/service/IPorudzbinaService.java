package com.example.OSAProjekat.service;

import java.util.List;

import com.example.OSAProjekat.model.dto.PorudzbinaSearchRequestDTO;
import com.example.OSAProjekat.model.dto.PorudzbinaSearchResponseDTO;
import com.example.OSAProjekat.model.entity.PorudzbinaSearch;

public interface IPorudzbinaService {

	void index(PorudzbinaSearchRequestDTO porudzbinaSearchRequestDTO);
	
	List<PorudzbinaSearchResponseDTO> getPorudzbineByKomentar(String komentar);
	
	List<PorudzbinaSearchResponseDTO> getAll();

}
