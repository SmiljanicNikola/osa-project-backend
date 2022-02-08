package com.example.OSAProjekat.service;

import java.util.List;

import com.example.OSAProjekat.model.dto.KorisnikDTO;
import com.example.OSAProjekat.model.dto.KupacDTO;
import com.example.OSAProjekat.model.dto.ProdavacDTO;
import com.example.OSAProjekat.model.entity.Kupac;
import com.example.OSAProjekat.model.entity.Prodavac;

public interface KupacService {

	public List<Kupac> listAll();
	
	public Kupac save(Kupac kupac);
		
	public Kupac get(Integer id);
		
	public void delete(Integer id);
	
	Kupac createKupac(KupacDTO kupacDTO, KorisnikDTO korisnikDTO);
	
	Kupac getByKorisnikUsername(String korisnikUsername);
}
