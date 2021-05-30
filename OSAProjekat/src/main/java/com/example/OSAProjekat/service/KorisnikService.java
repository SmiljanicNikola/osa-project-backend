package com.example.OSAProjekat.service;

import com.example.OSAProjekat.model.dto.KorisnikDTO;
import com.example.OSAProjekat.model.entity.Korisnik;

public interface KorisnikService {

	Korisnik findByUsername(String username);

    Korisnik createUser(KorisnikDTO korisnikDTO);
    
    Korisnik createProdavac(KorisnikDTO korisnikDTO);
	
}
