package com.example.OSAProjekat.service;

import java.util.List;

import com.example.OSAProjekat.model.dto.AdministratorDTO;
import com.example.OSAProjekat.model.dto.KorisnikDTO;
import com.example.OSAProjekat.model.entity.Administrator;


public interface AdministratorService {


	public List<Administrator> listAll();
	
	public Administrator save(Administrator administrator);
		
	public Administrator get(Integer id);
		
	public void delete(Integer id);
	
	Administrator createAdministrator(AdministratorDTO administratorDTO);
	
	Administrator createeAdministrator(AdministratorDTO administratorDTO, KorisnikDTO korisnikDTO);
	
}
