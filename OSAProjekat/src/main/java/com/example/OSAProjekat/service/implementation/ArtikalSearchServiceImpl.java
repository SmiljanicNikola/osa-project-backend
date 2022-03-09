package com.example.OSAProjekat.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.OSAProjekat.model.dto.ArtikalSearchRequestDTO;
import com.example.OSAProjekat.model.dto.ArtikalSearchResponseDTO;
import com.example.OSAProjekat.model.dto.PorudzbinaSearchResponseDTO;
import com.example.OSAProjekat.model.dto.mapper.ArtikalSearchMapper;
import com.example.OSAProjekat.model.dto.mapper.PorudzbinaSearchMapper;
import com.example.OSAProjekat.model.entity.ArtikalSearch;
import com.example.OSAProjekat.model.entity.PorudzbinaSearch;
import com.example.OSAProjekat.repository.IArtikalRepository;
import com.example.OSAProjekat.service.IArtikalService;

//Korisceno iskljucivo za ElasticSearch
@Service
public class ArtikalSearchServiceImpl implements IArtikalService{

	private final IArtikalRepository _artikalRepository;
	
	
	public ArtikalSearchServiceImpl(IArtikalRepository _artikalRepository) {
		super();
		this._artikalRepository = _artikalRepository;
	}

	@Override
	public void index(ArtikalSearchRequestDTO artikalSearchRequestDTO) {
		_artikalRepository.save(ArtikalSearchMapper.mapModel(artikalSearchRequestDTO));
	}

	@Override
	public List<ArtikalSearchResponseDTO> getArtikliByNaziv(String naziv) {
		List<ArtikalSearch> artikli = _artikalRepository.findAllByNaziv(naziv);
		return mapArtikalToArtikalresponsibleDTO(artikli);
	}
	
	public List<ArtikalSearchResponseDTO> mapArtikalToArtikalresponsibleDTO(List<ArtikalSearch> artikli){
		List<ArtikalSearchResponseDTO> artikliDTOS = new ArrayList<>();
		for(ArtikalSearch artikalSearch : artikli) {
			artikliDTOS.add(ArtikalSearchMapper.mapResponseDTO(artikalSearch));
		}
		return artikliDTOS;
	}
	

	@Override
	public List<ArtikalSearch> getAll() {
		return _artikalRepository.findAll();

	}

	@Override
	public List<ArtikalSearchResponseDTO> getArtikliByCenaGreaterThan(int cena) {
		List<ArtikalSearch> artikli = _artikalRepository.findAllByCenaGreaterThan(cena);
		return mapArtikalToArtikalresponsibleDTO(artikli);
	}

	@Override
	public List<ArtikalSearchResponseDTO> getArtikliByCenaLessThan(int cena) {
		List<ArtikalSearch> artikli = _artikalRepository.findAllByCenaLessThan(cena);
		return mapArtikalToArtikalresponsibleDTO(artikli);
	}

	@Override
	public List<ArtikalSearchResponseDTO> getArtikliByCenaGreatherThanAndLessThan(double minCena, int maxCena) {
		List<ArtikalSearch> artikli = _artikalRepository.findByCenaBetween(minCena, maxCena);
		return mapArtikalToArtikalresponsibleDTO(artikli);
	}

	@Override
	public Optional<ArtikalSearch> findById(String id) {
		Optional<ArtikalSearch> artikalSearch = _artikalRepository.findById(id);
		return artikalSearch;
	}

	@Override
	public void delete(String id) {
		_artikalRepository.deleteById(id);
		
	}

}
