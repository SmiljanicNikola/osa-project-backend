package com.example.OSAProjekat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OSAProjekat.model.dto.ArtikalDTO;
import com.example.OSAProjekat.model.dto.ProdavacDTO;
import com.example.OSAProjekat.model.entity.Artikal;
import com.example.OSAProjekat.model.entity.Prodavac;
import com.example.OSAProjekat.service.ProdavacService;

@RestController
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
	
}
