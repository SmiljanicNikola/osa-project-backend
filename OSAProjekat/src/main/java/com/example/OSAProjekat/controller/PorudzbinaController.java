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

import com.example.OSAProjekat.model.dto.ArtikalDTO;
import com.example.OSAProjekat.model.dto.PorudzbinaDTO;
import com.example.OSAProjekat.model.dto.ProdavacDTO;
import com.example.OSAProjekat.model.entity.Artikal;
import com.example.OSAProjekat.model.entity.Korisnik;
import com.example.OSAProjekat.model.entity.Porudzbina;
import com.example.OSAProjekat.service.KupacService;
import com.example.OSAProjekat.service.PorudzbinaService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping(value="api/porudzbine")
public class PorudzbinaController {
	
	@Autowired
	private PorudzbinaService porudzbinaService;
	
	@Autowired
	private KupacService kupacService;
	
	@GetMapping 
	public ResponseEntity<List<Porudzbina>> getPorudzbine(){
		List<Porudzbina> porudzbine = porudzbinaService.listAll();
		
		/*List<PorudzbinaDTO> porudzbineDTO = new ArrayList<>();
		for(Porudzbina p : porudzbine) {
			porudzbineDTO.add()
		}*/
		
		return new ResponseEntity<>(porudzbine, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PorudzbinaDTO> getPorudzbina(@PathVariable("id") Integer id){
		Porudzbina porudzbina = porudzbinaService.get(id);
		if(porudzbina == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new PorudzbinaDTO(porudzbina), HttpStatus.OK);
	}
	
	/*@GetMapping(value = "/username/{korisnikUsername}")
	public ResponseEntity<List<PorudzbinaDTO>> getPorudzbinaByUsernameKorisnika(@PathVariable("korisnikUsername") String korisnikUsername){
		List<Porudzbina> porudzbine = porudzbinaService.listAll();
		List<PorudzbinaDTO> porudzbineDTO = new ArrayList<>();
		for(Porudzbina p : porudzbine) {
			
			if(p.getKupac().getKorisnik().getUsername().equals(korisnikUsername)) {
				porudzbineDTO.add(new PorudzbinaDTO(p));
			}
		}
		return new ResponseEntity<>(porudzbineDTO, HttpStatus.OK);
		/*Porudzbina porudzbina = porudzbinaService.getByKorisnikusername(korisnikUsername);
		if(porudzbina == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
        return new ResponseEntity<>(new PorudzbinaDTO(porudzbina), HttpStatus.OK);Ovde je bio kraj komentara

	}*/
	@GetMapping(value = "/username/{korisnikUsername}")
	public ResponseEntity<List<Porudzbina>> getPorudzbinaByUsernameKorisnikaNeDTO(@PathVariable("korisnikUsername") String korisnikUsername){
		List<Porudzbina> porudzbine = porudzbinaService.listAll();
		List<Porudzbina> odgovarajucePorudzbine = new ArrayList<>();
		for(Porudzbina p : porudzbine) {
			
			if(p.getKupac().getKorisnik().getUsername().equals(korisnikUsername)) {
				odgovarajucePorudzbine.add(p);
			}
		}
		return new ResponseEntity<>(odgovarajucePorudzbine, HttpStatus.OK);
		/*Porudzbina porudzbina = porudzbinaService.getByKorisnikusername(korisnikUsername);
		if(porudzbina == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
        return new ResponseEntity<>(new PorudzbinaDTO(porudzbina), HttpStatus.OK);*/

	}
	@PutMapping(value = "/potvrdiPristiglost/{id}")
	public ResponseEntity<?> potvrdiPristiglost(
			@PathVariable Integer id) {
		try {
			Porudzbina existPorudzbina = porudzbinaService.get(id);
			if(existPorudzbina != null) {
				existPorudzbina.setDostavljeno(true);
		
				porudzbinaService.save(existPorudzbina);
			}
		return new ResponseEntity<>(HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> ostaviRecenziju(@RequestBody Porudzbina porudzbina, 
			@PathVariable Integer id) {
		try {
			Porudzbina existPorudzbina = porudzbinaService.get(id);
			if(existPorudzbina != null) {
				existPorudzbina.setKomentar(porudzbina.getKomentar());
				existPorudzbina.setOcena(porudzbina.getOcena());
		
				porudzbinaService.save(existPorudzbina);
			}
		return new ResponseEntity<>(HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

}
