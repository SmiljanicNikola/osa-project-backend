package com.example.OSAProjekat.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.OSAProjekat.model.dto.PorudzbinaSearchRequestDTO;
import com.example.OSAProjekat.model.dto.PorudzbinaSearchResponseDTO;
import com.example.OSAProjekat.model.dto.mapper.PorudzbinaSearchMapper;
import com.example.OSAProjekat.model.entity.ArtikalSearch;
import com.example.OSAProjekat.model.entity.PorudzbinaSearch;
import com.example.OSAProjekat.repository.IPorudzbinaRepository;
import com.example.OSAProjekat.service.IPorudzbinaService;

@Service
public class PorudzbinaSearchServiceImpl implements IPorudzbinaService {

	private final IPorudzbinaRepository _porudzbinaRepository;
	
	

	public PorudzbinaSearchServiceImpl(IPorudzbinaRepository _porudzbinaRepository) {
		super();
		this._porudzbinaRepository = _porudzbinaRepository;
	}

	@Override
	public void index(PorudzbinaSearchRequestDTO porudzbinaSearchRequestDTO) {
		_porudzbinaRepository.save(PorudzbinaSearchMapper.mapModel(porudzbinaSearchRequestDTO));
		
	}

	@Override
	public List<PorudzbinaSearchResponseDTO> getPorudzbineByKomentar(String komentar) {
		List<PorudzbinaSearch> porudzbine = _porudzbinaRepository.findAllByKomentar(komentar);
		return mapPorudzbineToPorudzbinaresponsibleDTO(porudzbine);
	}

	public List<PorudzbinaSearchResponseDTO> mapPorudzbineToPorudzbinaresponsibleDTO(List<PorudzbinaSearch> porudzbine){
		List<PorudzbinaSearchResponseDTO> porudzbinaDTOS = new ArrayList<>();
		for(PorudzbinaSearch porudzbinaSearch : porudzbine) {
			porudzbinaDTOS.add(PorudzbinaSearchMapper.mapResponseDTO(porudzbinaSearch));
		}
		return porudzbinaDTOS;
	}

	@Override
	public List<PorudzbinaSearchResponseDTO> getAll() {
		List<PorudzbinaSearch> svePorudzbine = _porudzbinaRepository.findAll();
		return mapPorudzbineToPorudzbinaresponsibleDTO(svePorudzbine);
	}

	/*@Override
	public List<PorudzbinaSearchResponseDTO> getPorudzbineByOcenaGreaterThan(int ocena) {
		List<PorudzbinaSearch> porudzbine = _porudzbinaRepository.findAllByOcenaGreaterThan(ocena);
		return mapPorudzbineToPorudzbinaresponsibleDTO(porudzbine);
	}

	@Override
	public List<PorudzbinaSearchResponseDTO> getPorudzbineByOcenaLessThan(int ocena) {
		List<PorudzbinaSearch> porudzbine = _porudzbinaRepository.findAllByOcenaLessThan(ocena);
		return mapPorudzbineToPorudzbinaresponsibleDTO(porudzbine);
	}*/

	@Override
	public List<PorudzbinaSearchResponseDTO> getPorudzbineByOcenaGreaterThanAndLessThan(int minOcena, int maxOcena) {
		List<PorudzbinaSearch> porudzbine = _porudzbinaRepository.findByOcenaBetween(minOcena, maxOcena);
		return mapPorudzbineToPorudzbinaresponsibleDTO(porudzbine);
	}

	@Override
	public List<PorudzbinaSearchResponseDTO> getAllByKupacId(int id) {
		List<PorudzbinaSearch> porudzbine = _porudzbinaRepository.findAllByKupacId(id);
		return mapPorudzbineToPorudzbinaresponsibleDTO(porudzbine);
	}

	@Override
	public PorudzbinaSearch save(PorudzbinaSearchRequestDTO PorudzbinaSearchRequestDTO) {
		return _porudzbinaRepository.save(PorudzbinaSearchRequestDTO);
		
	}

	@Override
	public Optional<PorudzbinaSearch> findById(String id) {
		Optional<PorudzbinaSearch> artikalSearch = _porudzbinaRepository.findById(id);
		return artikalSearch;
	}
	
}
