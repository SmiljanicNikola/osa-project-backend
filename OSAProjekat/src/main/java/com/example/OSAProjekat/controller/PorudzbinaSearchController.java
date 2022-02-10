package com.example.OSAProjekat.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.OSAProjekat.model.dto.PorudzbinaKomentarRequestDTO;
import com.example.OSAProjekat.model.dto.PorudzbinaSearchRequestDTO;
import com.example.OSAProjekat.model.dto.PorudzbinaSearchResponseDTO;
import com.example.OSAProjekat.model.entity.ArtikalSearch;
import com.example.OSAProjekat.model.entity.Korisnik;
import com.example.OSAProjekat.model.entity.PorudzbinaSearch;
import com.example.OSAProjekat.service.IPorudzbinaService;
import com.example.OSAProjekat.service.PorudzbinaService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/porudzbine4")
public class PorudzbinaSearchController {
	
	private final IPorudzbinaService _porudzbinaService;
	
	
	
	
	public PorudzbinaSearchController(IPorudzbinaService _porudzbinaService) {
		super();
		this._porudzbinaService = _porudzbinaService;
		
	}
	@GetMapping
	public List<PorudzbinaSearchResponseDTO> getAll(){
		return _porudzbinaService.getAll();
	}
	@GetMapping("/kupac/{id}")
	public List<PorudzbinaSearchResponseDTO> getAllByKupacId(@PathVariable int id){
		List<PorudzbinaSearchResponseDTO> porudzbineSve = _porudzbinaService.getAll();
		List<PorudzbinaSearchResponseDTO> porudzbineOdgovarajuce = new ArrayList<>();
		for(PorudzbinaSearchResponseDTO p : porudzbineSve) {
			if(p.getKupacId() == id ) {
				porudzbineOdgovarajuce.add(p);
			}
		}
		return porudzbineSve;
	}
	
	@GetMapping("/id/{id}")
	public Optional<PorudzbinaSearch> getById(@PathVariable String id){
		Optional<PorudzbinaSearch> artikalSearch = _porudzbinaService.findById(id);
		return artikalSearch;
	}
	
	@PostMapping
	public void index(@RequestBody PorudzbinaSearchRequestDTO porudzbinaSearchRequestDTO) {
		_porudzbinaService.index(porudzbinaSearchRequestDTO);
	}
	
	@GetMapping("/komentar")
	public List<PorudzbinaSearchResponseDTO> getByKomentar(@RequestBody PorudzbinaKomentarRequestDTO porudzbinaKomentarRequestDTO){
		return _porudzbinaService.getPorudzbineByKomentar(porudzbinaKomentarRequestDTO.getKomentar());
	}
	
	@GetMapping("/{komentar}")
	public List<PorudzbinaSearchResponseDTO> getByKomentar(@PathVariable String komentar){
		return _porudzbinaService.getPorudzbineByKomentar(komentar);
		
	}
	
	/*@GetMapping("/minOcena")
	public List<PorudzbinaSearchResponseDTO> getByOcenaGreaterThan(@RequestParam(name="minOcena") int ocena){
		return _porudzbinaService.getPorudzbineByOcenaGreaterThan(ocena);
	}
	@GetMapping("/maxOcena")
	public List<PorudzbinaSearchResponseDTO> getByOcenaLessThan(@RequestParam(name="maxOcena") int ocena){
		return _porudzbinaService.getPorudzbineByOcenaLessThan(ocena);
	}*/
	
	@GetMapping("/ocena")
	public List<PorudzbinaSearchResponseDTO> getByOcenaGreaterThanAndLessThan(@RequestParam(name="minOcena") int minOcena, @RequestParam(name="maxOcena") int maxOcena){
		return _porudzbinaService.getPorudzbineByOcenaGreaterThanAndLessThan(minOcena, maxOcena);
	}
	
	/*@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody PorudzbinaSearchRequestDTO porudzbinaSearchRequestDTO, @PathVariable String id) {
		try {
			PorudzbinaSearchResponseDTO porudzbinaSearchResponseDTO = _porudzbinaService.g
			if(porudzbinaSearchResponseDTO != null) {
				porudzbinaSearchResponseDTO.setKomentar(porudzbinaSearchRequestDTO.getKomentar());
				porudzbinaSearchRequestDTO.setOcena(porudzbinaSearchRequestDTO.getOcena());
				porudzbinaServiceJPA.save(porudzbinaSearchRequestDTO);
			}
		return new ResponseEntity<>(HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
}*/
}
