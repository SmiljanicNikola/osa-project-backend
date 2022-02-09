package com.example.OSAProjekat.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OSAProjekat.model.dto.ArtikalDTO;
import com.example.OSAProjekat.model.dto.StavkaDTO;
import com.example.OSAProjekat.model.entity.AddStavkaRequest;
import com.example.OSAProjekat.model.entity.Stavka;
import com.example.OSAProjekat.service.ArtikalService;
import com.example.OSAProjekat.service.StavkaService;

@CrossOrigin(origins="http://localhost:3000")
@RequestMapping(value="api/stavke")
@RestController
public class StavkaController {
	
	@Autowired
	private StavkaService stavkaService;
	
	@Autowired
	private ArtikalService artikalService;
	
	@GetMapping
	public ResponseEntity<List<StavkaDTO>> getStavke(){
		List<Stavka> stavke = stavkaService.listAll();
		
		List<StavkaDTO> stavkeDTO = new ArrayList<>();
		for(Stavka s : stavke) {
			stavkeDTO.add(new StavkaDTO(s));
		}
		return new ResponseEntity<>(stavkeDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<StavkaDTO> getStavka(@PathVariable("id") Integer id){
		Stavka stavka = stavkaService.get(id);
		if(stavka == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new StavkaDTO(stavka), HttpStatus.OK);
	}
	
	@PostMapping()
	@Produces("MediaType.APPLICATION_JSON")
	public ResponseEntity<StavkaDTO> saveStavka(@RequestBody AddStavkaRequest addStavkaRequest){
		
		Stavka stavka = new Stavka();
		int id = hashCode();
		stavka.setId(id);
		stavka.setKolicina(addStavkaRequest.getKolicina());
		stavka.setArtikal(this.artikalService.get(addStavkaRequest.getArtikalId()));
		
		stavka = stavkaService.save(stavka);
		return new ResponseEntity<>(new StavkaDTO(stavka), HttpStatus.CREATED);
		
	}

}
