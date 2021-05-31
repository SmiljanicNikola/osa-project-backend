package com.example.OSAProjekat.service;

import java.util.List;

import com.example.OSAProjekat.model.dto.KorisnikDTO;
import com.example.OSAProjekat.model.entity.Korisnik;
import com.example.OSAProjekat.model.entity.Prodavac;

public interface KorisnikService {

	public List<Korisnik> listAll();
	
	Korisnik findByUsername(String username);

    Korisnik createUser(KorisnikDTO korisnikDTO);
    
    Korisnik createProdavac(KorisnikDTO korisnikDTO);
	
}
