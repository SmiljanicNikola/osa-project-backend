package com.example.OSAProjekat.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OSAProjekat.model.entity.Kupac;
import com.example.OSAProjekat.repository.KupacRepository;
import com.example.OSAProjekat.repository.ProdavacRepository;
import com.example.OSAProjekat.service.KupacService;

@Service
public class KupacServiceImpl implements KupacService {

	@Autowired
	private KupacRepository kupacRepo;
	
	
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

}
