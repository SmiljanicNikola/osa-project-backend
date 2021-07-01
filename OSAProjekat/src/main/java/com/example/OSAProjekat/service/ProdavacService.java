package com.example.OSAProjekat.service;

import java.util.List;

import com.example.OSAProjekat.model.dto.KorisnikDTO;
import com.example.OSAProjekat.model.dto.ProdavacDTO;
import com.example.OSAProjekat.model.entity.Artikal;
import com.example.OSAProjekat.model.entity.Korisnik;
import com.example.OSAProjekat.model.entity.Prodavac;

public interface ProdavacService {

	public List<Prodavac> listAll();
	
	public Prodavac save(Prodavac prodavac);
		
    Prodavac findOne(Integer id);
		
	public void delete(Integer id);
	
	Prodavac createeProdavac(ProdavacDTO prodavacDTO);
	
	Prodavac createeProdavac(ProdavacDTO prodavacDTO, KorisnikDTO korisnikDTO);
	
}
