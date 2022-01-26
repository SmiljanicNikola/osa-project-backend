package com.example.OSAProjekat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OSAProjekat.model.dto.PorudzbinaDTO;
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
	
	
	
	
	
	
	

}
