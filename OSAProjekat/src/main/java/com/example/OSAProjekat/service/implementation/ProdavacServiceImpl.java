package com.example.OSAProjekat.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.OSAProjekat.model.dto.KorisnikDTO;
import com.example.OSAProjekat.model.dto.ProdavacDTO;
import com.example.OSAProjekat.model.entity.Korisnik;
import com.example.OSAProjekat.model.entity.Prodavac;
import com.example.OSAProjekat.model.entity.Roles;
import com.example.OSAProjekat.repository.ArtikalRepository;
import com.example.OSAProjekat.repository.KorisnikRepository;
import com.example.OSAProjekat.repository.ProdavacRepository;
import com.example.OSAProjekat.service.ProdavacService;

@Service
public class ProdavacServiceImpl implements ProdavacService {

	@Autowired
	private KorisnikRepository korisnikRepository;

	@Autowired
	private ProdavacService prodavacService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ProdavacRepository prodavacRepo;
	
	@Override
	public List<Prodavac> listAll() {
		return prodavacRepo.findAll();
	}

	@Override
	public Prodavac save(Prodavac prodavac) {
		prodavacRepo.save(prodavac);
		return prodavac;
	}

	@Override
	public Prodavac findOne(Integer id) {
		return prodavacRepo.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public Prodavac createeProdavac(ProdavacDTO prodavacDTO, KorisnikDTO korisnikDTO) {
		
			//Sam korisnik
		 	Korisnik newKorisnik = new Korisnik();
		 	//newKorisnik.setId(korisnikDTO.getId());
	        newKorisnik.setIme(korisnikDTO.getIme());
	        newKorisnik.setPrezime(korisnikDTO.getPrezime());
	        newKorisnik.setUsername(korisnikDTO.getUsername());
	        newKorisnik.setPassword(passwordEncoder.encode(korisnikDTO.getPassword()));
	        newKorisnik.setBlokiran(false);
	        newKorisnik.setRole(Roles.PRODAVAC);
	        newKorisnik = korisnikRepository.save(newKorisnik);
		
	        //Sam prodavac
		 	Prodavac newProdavac = new Prodavac();
		 	newProdavac.setKorisnik(newKorisnik);
		 	newProdavac.setPoslujeOd(prodavacDTO.getPoslujeOd());
		 	newProdavac.setEmail(prodavacDTO.getEmail());
		 	newProdavac.setAdresa(prodavacDTO.getAdresa());
		 	newProdavac.setNaziv(prodavacDTO.getNaziv());
		 	
	        newProdavac = prodavacRepo.save(newProdavac);
	        
	        return newProdavac;
	}

	@Override
	public Prodavac createeProdavac(ProdavacDTO prodavacDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prodavac getByKorisnikId(int korisnikId) {
		return prodavacRepo.findByKorisnikId(korisnikId);
	}

	@Override
	public Prodavac getByKorisnikUsername(String korisnikUsername) {
		return prodavacRepo.findByKorisnikUsername(korisnikUsername);
	}

}
