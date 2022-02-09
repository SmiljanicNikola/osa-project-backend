package com.example.OSAProjekat.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OSAProjekat.model.entity.Porudzbina;
import com.example.OSAProjekat.repository.PorudzbinaRepository;
import com.example.OSAProjekat.service.PorudzbinaService;

@Service
public class PorudzbinaServiceImpl implements PorudzbinaService {

	@Autowired
	private PorudzbinaRepository porudzbinaRepo;
	
	@Override
	public List<Porudzbina> listAll() {
		return porudzbinaRepo.findAll();
	}

	@Override
	public Porudzbina save(Porudzbina porudzbina) {
		porudzbinaRepo.save(porudzbina);
		return porudzbina;
	}

	@Override
	public Porudzbina get(Integer id) {
		return porudzbinaRepo.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {
		porudzbinaRepo.deleteById(id);
		
	}

	@Override
	public Porudzbina getByKorisnikusername(String username) {
		return porudzbinaRepo.findByKupacKorisnikUsername(username);
	}

}
