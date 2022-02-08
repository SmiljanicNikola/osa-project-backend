package com.example.OSAProjekat.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.OSAProjekat.model.dto.ArtikalNazivRequestDTO;
import com.example.OSAProjekat.model.dto.ArtikalSearchRequestDTO;
import com.example.OSAProjekat.model.dto.ArtikalSearchResponseDTO;
import com.example.OSAProjekat.model.dto.PorudzbinaSearchResponseDTO;
import com.example.OSAProjekat.model.entity.ArtikalSearch;
import com.example.OSAProjekat.service.IArtikalService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/artiklii")
public class ArtikalSearchController {
	
	private final IArtikalService _artikalService;

	public ArtikalSearchController(IArtikalService _artikalService) {
		super();
		this._artikalService = _artikalService;
	}
	
	@PostMapping
	public void index(@RequestBody ArtikalSearchRequestDTO artikalSearchRequestDTO) {
		_artikalService.index(artikalSearchRequestDTO);
	}
	
	@GetMapping("/naziv")
	public List<ArtikalSearchResponseDTO> getByNaziv(@RequestBody ArtikalNazivRequestDTO artikalNazivRequestDTO){
		return _artikalService.getArtikliByNaziv(artikalNazivRequestDTO.getNaziv());
	}
	
	@GetMapping("/{naziv}")
	public List<ArtikalSearchResponseDTO> getByNaziv(@PathVariable String naziv){
		return _artikalService.getArtikliByNaziv(naziv);
	}
	
	@GetMapping
	public List<ArtikalSearch> getAll(){
		return _artikalService.getAll();
	}
	
	@GetMapping("/minCena")
	public List<ArtikalSearchResponseDTO> getByCenaGreaterThan(@RequestParam(name="minCena") int cena){
		return _artikalService.getArtikliByCenaGreaterThan(cena);
		
	}
	@GetMapping("/maxCena")
	public List<ArtikalSearchResponseDTO> getByCenaLessThan(@RequestParam(name="maxCena") int cena){
		return _artikalService.getArtikliByCenaLessThan(cena);
		
	}
	
	@GetMapping("/cena")
	public List<ArtikalSearchResponseDTO> getByGreaterThanAndLessThan(@RequestParam(name="minCena") int minCena, @RequestParam(name="maxCena") int maxCena){
		return _artikalService.getArtikliByCenaGreatherThanAndLessThan(minCena, maxCena);
	}
}
