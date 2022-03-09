package com.example.OSAProjekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.OSAProjekat.model.entity.Artikal;
import com.example.OSAProjekat.repository.ArtikalRepository;


public interface ArtikalService {
	
	public List<Artikal> listAll();
		
	public Artikal save(Artikal artikal);
		
	public Artikal get(Integer id);
		
	public void delete(Integer id);
		
}
