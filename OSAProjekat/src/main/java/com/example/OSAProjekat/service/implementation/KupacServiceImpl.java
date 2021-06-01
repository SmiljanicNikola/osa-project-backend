package com.example.OSAProjekat.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.OSAProjekat.model.dto.KorisnikDTO;
import com.example.OSAProjekat.model.dto.KupacDTO;
import com.example.OSAProjekat.model.entity.Korisnik;
import com.example.OSAProjekat.model.entity.Kupac;
import com.example.OSAProjekat.model.entity.Roles;
import com.example.OSAProjekat.repository.KorisnikRepository;
import com.example.OSAProjekat.repository.KupacRepository;
import com.example.OSAProjekat.repository.ProdavacRepository;
import com.example.OSAProjekat.service.KupacService;

@Service
public class KupacServiceImpl implements KupacService {

	@Autowired
	private KorisnikRepository korisnikRepository;
	
	@Autowired
	private KupacRepository kupacRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public List<Kupac> listAll() {
		return kupacRepo.findAll();
	}

	@Override
	public Kupac save(Kupac kupac) {
		kupacRepo.save(kupac);
		return kupac;
	}

	@Override
	public Kupac get(Integer id) {
		return kupacRepo.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Kupac createKupac(KupacDTO kupacDTO, KorisnikDTO korisnikDTO) {
		Korisnik newKorisnik = new Korisnik();
		
		 newKorisnik.setIme(korisnikDTO.getIme());
	     newKorisnik.setPrezime(korisnikDTO.getPrezime());
	     newKorisnik.setUsername(korisnikDTO.getUsername());
	     newKorisnik.setPassword(passwordEncoder.encode(korisnikDTO.getPassword()));
	     newKorisnik.setBlokiran(false);
	     newKorisnik.setRole(Roles.KUPAC);
	     newKorisnik = korisnikRepository.save(newKorisnik);
	     
	     Kupac newKupac = new Kupac();
	     newKupac.setKorisnik(newKorisnik);
	     newKupac.setAdresa(kupacDTO.getAdresa());
	    
	     newKupac = kupacRepo.save(newKupac);
	       
	     return newKupac;
	     
	}

}
