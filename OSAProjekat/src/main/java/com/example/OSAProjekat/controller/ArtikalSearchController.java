package com.example.OSAProjekat.controller;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.example.OSAProjekat.model.entity.Artikal;
import com.example.OSAProjekat.model.entity.ArtikalSearch;
import com.example.OSAProjekat.service.IArtikalService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/artikli7")
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
	
	@GetMapping("/id/{id}")
	public Optional<ArtikalSearch> getById(@PathVariable String id){
		Optional<ArtikalSearch> artikalSearch = _artikalService.findById(id);
		return artikalSearch;
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
	
	/*@PutMapping(value="/update/{/id}")
	@Consumes("MediaType.APPLICATION_JSON")
	@Produces("MediaType.APPLICATION_JSON")
	public ResponseEntity<ArtikalSearchResponseDTO> updateArtikalElastic(@ReustBody )*/
	
	@DeleteMapping(value = "delete/{id}")
	@Consumes("MediaType.APPLICATION_JSON")
	@Produces("MediaType.APPLICATION_JSON")
	    public ResponseEntity<?> deleteArtikal(@PathVariable("id") String id) {
	        Optional<ArtikalSearch> artikalSearch = _artikalService.findById(id);
	        if (artikalSearch != null) {
	        	_artikalService.delete(id);
	            return new ResponseEntity<>(HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
}
