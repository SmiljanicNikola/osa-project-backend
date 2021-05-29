package com.example.OSAProjekat.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OSAProjekat.model.entity.Artikal;
import com.example.OSAProjekat.repository.ArtikalRepository;
import com.example.OSAProjekat.service.ArtikalService;


@Service
public class ArtikalServiceImpl implements ArtikalService {

	@Autowired
	private ArtikalRepository artikalRepo;
	
	@Override
	public List<Artikal> listAll() {
		return artikalRepo.findAll();
	}

	@Override
	public Artikal save(Artikal artikal) {
		artikalRepo.save(artikal);
		return artikal;
		
	}

	@Override
	public Artikal get(Integer id) {
		return artikalRepo.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		artikalRepo.deleteById(id);
		
	}

}
