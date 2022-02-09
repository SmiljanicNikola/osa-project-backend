package com.example.OSAProjekat.model.dto.mapper;

import com.example.OSAProjekat.model.dto.ArtikalSearchRequestDTO;
import com.example.OSAProjekat.model.dto.ArtikalSearchResponseDTO;
import com.example.OSAProjekat.model.entity.ArtikalSearch;

public class ArtikalSearchMapper {
	
	public static ArtikalSearch mapModel(ArtikalSearchRequestDTO artikalSearchRequestDTO) {
		return new ArtikalSearch(
				artikalSearchRequestDTO.getId(),
				artikalSearchRequestDTO.getNaziv(),
				artikalSearchRequestDTO.getOpis(),
				artikalSearchRequestDTO.getCena(),
				artikalSearchRequestDTO.getPutanjaSlike(),
				artikalSearchRequestDTO.getProdavacId()
				);
	}
	
	public static ArtikalSearchResponseDTO mapResponseDTO(ArtikalSearch artikalSearch) {
		return new ArtikalSearchResponseDTO(
				artikalSearch.getId(),
				artikalSearch.getNaziv(),
				artikalSearch.getOpis(),
				artikalSearch.getCena(),
				artikalSearch.getPutanjaSlike(),
				artikalSearch.getProdavacId()
				);
	}
}
