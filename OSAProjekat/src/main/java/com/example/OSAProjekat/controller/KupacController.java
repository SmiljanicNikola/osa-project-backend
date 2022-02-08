package com.example.OSAProjekat.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OSAProjekat.model.dto.KupacDTO;
import com.example.OSAProjekat.model.entity.Kupac;
import com.example.OSAProjekat.model.entity.Prodavac;
import com.example.OSAProjekat.service.KupacService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping(value = "api/kupci")
public class KupacController {

	@Autowired
	private KupacService kupacService;
	
	@GetMapping
	public ResponseEntity<List<KupacDTO>> getKupac(){
		List<Kupac> kupci = kupacService.listAll();
		
		List<KupacDTO> kupciDTO = new ArrayList<>();
		for(Kupac k : kupci) {
			kupciDTO.add(new KupacDTO(k));
		}
		
		return new ResponseEntity<>(kupciDTO, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/username/{korisnikUsername}")
	public ResponseEntity<KupacDTO> getKupacByUsername(@PathVariable("korisnikUsername") String korisnikUsername){
		Kupac kupac = kupacService.getByKorisnikUsername(korisnikUsername);
		if(kupac == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new KupacDTO(kupac),HttpStatus.OK);
	}
	@PutMapping("/username/{userName}")
	public ResponseEntity<?> update(@RequestBody Kupac kupac, @PathVariable String userName){
		try {
			Kupac existKupac = kupacService.getByKorisnikUsername(userName);
			if(existKupac != null) {
				existKupac.setAdresa(existKupac.getAdresa());
				kupacService.save(existKupac);
			}
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
