package com.example.OSAProjekat.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.OSAProjekat.model.dto.KorisnikDTO;
import com.example.OSAProjekat.model.entity.Korisnik;
import com.example.OSAProjekat.model.entity.Prodavac;
import com.example.OSAProjekat.model.entity.Roles;
import com.example.OSAProjekat.repository.KorisnikRepository;
import com.example.OSAProjekat.service.KorisnikService;
import com.example.OSAProjekat.service.ProdavacService;

@Service
public class KorisnikServiceImpl implements KorisnikService {

	
	@Autowired
	private KorisnikRepository korisnikRepository;

	@Autowired
	private ProdavacService prodavacService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Override
	public Korisnik findByUsername(String username) {
		 Optional<Korisnik> korisnik = korisnikRepository.findFirstByUsername(username);
	        if (!korisnik.isEmpty()) {
	            return korisnik.get();
	        }
	        return null;
	}

	@Override
	public Korisnik createUser(KorisnikDTO korisnikDTO) {
		 Optional<Korisnik> korisnik = korisnikRepository.findFirstByUsername(korisnikDTO.getUsername());

	        if(korisnik.isPresent()){
	            return null;
	        }

	        Korisnik newKorisnik = new Korisnik();
	        newKorisnik.setIme(korisnikDTO.getIme());
	        newKorisnik.setPrezime(korisnikDTO.getPrezime());
	        newKorisnik.setUsername(korisnikDTO.getUsername());
	        newKorisnik.setPassword(passwordEncoder.encode(korisnikDTO.getPassword()));
	        newKorisnik.setBlokiran(false);
	        newKorisnik.setRole(Roles.KUPAC);
	        newKorisnik = korisnikRepository.save(newKorisnik);

	        return newKorisnik;
	}
	
	
	@Override
	public Korisnik createProdavac(KorisnikDTO korisnikDTO) {
		 Optional<Korisnik> korisnik = korisnikRepository.findFirstByUsername(korisnikDTO.getUsername());

	        if(korisnik.isPresent()){
	            return null;
	        }

	        Korisnik newKorisnik = new Korisnik();
	        newKorisnik.setIme(korisnikDTO.getIme());
	        newKorisnik.setPrezime(korisnikDTO.getPrezime());
	        newKorisnik.setUsername(korisnikDTO.getUsername());
	        newKorisnik.setPassword(passwordEncoder.encode(korisnikDTO.getPassword()));
	        newKorisnik.setBlokiran(false);
	        newKorisnik.setRole(Roles.PRODAVAC);
	        newKorisnik = korisnikRepository.save(newKorisnik);
	        

	        return newKorisnik;
	}

	@Override
	public List<Korisnik> listAll() {
		return korisnikRepository.findAll();

	}
	
	

}
