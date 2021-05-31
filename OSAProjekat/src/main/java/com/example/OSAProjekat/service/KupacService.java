package com.example.OSAProjekat.service;

import java.util.List;

import com.example.OSAProjekat.model.entity.Kupac;

public interface KupacService {

	public List<Kupac> listAll();
	
	public Kupac save(Kupac kupac);
		
	public Kupac get(Integer id);
		
	public void delete(Integer id);
	
}
