package com.example.OSAProjekat.service;

import java.util.List;

import com.example.OSAProjekat.model.entity.Porudzbina;

public interface PorudzbinaService {

	public List<Porudzbina> listAll();
	
	public Porudzbina save(Porudzbina porudzbina);
	
	public Porudzbina get(Integer id);
	
	public void delete(Integer id);
	
}
