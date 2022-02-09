package com.example.OSAProjekat.service;

import java.util.List;

import com.example.OSAProjekat.model.dto.StavkaDTO;
import com.example.OSAProjekat.model.entity.Stavka;

public interface StavkaService {
	
	public List<Stavka> listAll();
		
	Stavka createStavka(StavkaDTO stavkaDTO);
	
	Stavka get(Integer id);
	
	Stavka save(Stavka stavka);
	
}
