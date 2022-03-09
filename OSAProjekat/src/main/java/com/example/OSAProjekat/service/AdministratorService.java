package com.example.OSAProjekat.service;

import java.util.List;

import com.example.OSAProjekat.model.dto.AdministratorDTO;
import com.example.OSAProjekat.model.dto.KorisnikDTO;
import com.example.OSAProjekat.model.dto.ProdavacDTO;
import com.example.OSAProjekat.model.entity.Administrator;
import com.example.OSAProjekat.model.entity.Prodavac;


public interface AdministratorService {

	public List<Administrator> listAll();
	
	public Administrator save(Administrator administrator);
		
	public Administrator get(Integer id);
		
	public void delete(Integer id);
	
	//Administrator createAdministrator(AdministratorDTO administratorDTO);
	
	Administrator createAdministrator(AdministratorDTO administratorDTO,  KorisnikDTO korisnikDTO);	
}
