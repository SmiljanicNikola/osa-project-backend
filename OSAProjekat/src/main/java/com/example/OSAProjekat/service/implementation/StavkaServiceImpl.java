package com.example.OSAProjekat.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OSAProjekat.model.dto.StavkaDTO;
import com.example.OSAProjekat.model.entity.Stavka;
import com.example.OSAProjekat.repository.StavkaRepository;
import com.example.OSAProjekat.service.StavkaService;

@Service
public class StavkaServiceImpl  implements StavkaService{

	@Autowired
	private StavkaRepository stavkaRepository;
	
	@Autowired
	private StavkaService stavkaService;

	@Override
	public List<Stavka> listAll() {
		return stavkaRepository.findAll();
	}


	@Override
	public Stavka createStavka(StavkaDTO stavkaDTO) {
		return null;
	}

	@Override
	public Stavka get(Integer id) {
		return stavkaRepository.findById(id).orElse(null);
	}

	@Override
	public Stavka save(Stavka stavka) {
		stavkaRepository.save(stavka);
		return stavka;
	}
	
}
