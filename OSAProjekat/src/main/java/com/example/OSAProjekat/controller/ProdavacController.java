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
import com.example.OSAProjekat.model.dto.ProdavacDTO;
import com.example.OSAProjekat.model.entity.Artikal;
import com.example.OSAProjekat.model.entity.Prodavac;
import com.example.OSAProjekat.service.ProdavacService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping(value = "api/prodavci")
public class ProdavacController {

	
	@Autowired
	private ProdavacService prodavacService;
	
	@GetMapping
	public ResponseEntity<List<ProdavacDTO>> getProdavce(){
		List<Prodavac> prodavci = prodavacService.listAll();
		
		List<ProdavacDTO> prodavciDTO = new ArrayList<>();
		for(Prodavac p : prodavci) {
			prodavciDTO.add(new ProdavacDTO(p));
		}
		
		return new ResponseEntity<>(prodavciDTO, HttpStatus.OK);
		
	}
	
	
	@GetMapping(value = "/{id}")
    public ResponseEntity<ProdavacDTO> getProdavac(@PathVariable("id") Integer id) {
        Prodavac prodavac = prodavacService.findOne(id);
        if (prodavac == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new ProdavacDTO(prodavac), HttpStatus.OK);
    }
	
	@PutMapping("/username/{userName}")
	public ResponseEntity<?> update(@RequestBody Prodavac prodavac, @PathVariable String userName){
		try {
			Prodavac existProdavac = prodavacService.getByKorisnikUsername(userName);
			if(existProdavac != null) {
				existProdavac.setAdresa(prodavac.getAdresa());
				existProdavac.setEmail(prodavac.getEmail());
				prodavacService.save(existProdavac);
			}
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/korisnik/{korisnikId}")
    public ResponseEntity<ProdavacDTO> getProdavacByKorisnikId(@PathVariable("korisnikId") Integer korisnikId) {
        Prodavac prodavac = prodavacService.getByKorisnikId(korisnikId);
        if (prodavac == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new ProdavacDTO(prodavac), HttpStatus.OK);
    }
	
	@GetMapping(value = "/username/{korisnikUsername}")
    public ResponseEntity<ProdavacDTO> getProdavacByUsername(@PathVariable("korisnikUsername") String korisnikUsername) {
        Prodavac prodavac = prodavacService.getByKorisnikUsername(korisnikUsername);
        if (prodavac == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new ProdavacDTO(prodavac), HttpStatus.OK);
    }
	
}
