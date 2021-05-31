package com.example.OSAProjekat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OSAProjekat.model.dto.KupacDTO;
import com.example.OSAProjekat.model.entity.Kupac;

import com.example.OSAProjekat.service.KupacService;

@RestController
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
	
}
