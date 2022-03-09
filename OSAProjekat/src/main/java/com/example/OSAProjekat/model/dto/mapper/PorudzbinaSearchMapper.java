package com.example.OSAProjekat.model.dto.mapper;

import java.time.LocalDate;
import com.example.OSAProjekat.model.dto.PorudzbinaSearchRequestDTO;
import com.example.OSAProjekat.model.dto.PorudzbinaSearchResponseDTO;
import com.example.OSAProjekat.model.entity.PorudzbinaSearch;

public class PorudzbinaSearchMapper {

	public static PorudzbinaSearch mapModel(PorudzbinaSearchRequestDTO porudzbinaSearchRequestDTO) {
		return new PorudzbinaSearch(
				porudzbinaSearchRequestDTO.getId(),
				porudzbinaSearchRequestDTO.getSatnica(),
				porudzbinaSearchRequestDTO.isDostavljeno(),
				porudzbinaSearchRequestDTO.getOcena(),
				porudzbinaSearchRequestDTO.getKomentar(),
				porudzbinaSearchRequestDTO.isAnonimanKomentar(),
				porudzbinaSearchRequestDTO.isArhiviranKomentar(),
				porudzbinaSearchRequestDTO.getKupacId(),
				porudzbinaSearchRequestDTO.getStavkaId()

			
				);
	}
	
	public static PorudzbinaSearchResponseDTO mapResponseDTO(PorudzbinaSearch porudzbinaSearch) {
		return new PorudzbinaSearchResponseDTO(
				porudzbinaSearch.getId(),
				porudzbinaSearch.getSatnica(),
				porudzbinaSearch.isDostavljeno(),
				porudzbinaSearch.getOcena(),
				porudzbinaSearch.getKomentar(),
				porudzbinaSearch.isAnonimanKomentar(),
				porudzbinaSearch.isArhiviranKomentar(),
				porudzbinaSearch.getKupacId(),
				porudzbinaSearch.getStavkaId()
				);
	}
	
}
