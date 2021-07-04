package com.example.OSAProjekat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OSAProjekat.model.dto.AdministratorDTO;
import com.example.OSAProjekat.model.entity.Administrator;
import com.example.OSAProjekat.service.AdministratorService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping(value = "api/admini")
public class AdministratorController {

	
	@Autowired
	private AdministratorService adminiService;
	
	@GetMapping
	public ResponseEntity<List<AdministratorDTO>> getAdmini(){
		List<Administrator> administratori = adminiService.listAll();
		
		List<AdministratorDTO> administratoriDTO = new ArrayList<>();
		for(Administrator a : administratori) {
			administratoriDTO.add(new AdministratorDTO(a));
		}
		
		return new ResponseEntity<>(administratoriDTO, HttpStatus.OK);
		
	}
	
	
	
	
}
