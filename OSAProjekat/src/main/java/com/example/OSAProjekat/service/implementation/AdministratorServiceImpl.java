package com.example.OSAProjekat.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.OSAProjekat.model.dto.AdministratorDTO;
import com.example.OSAProjekat.model.dto.KorisnikDTO;
import com.example.OSAProjekat.model.entity.Administrator;
import com.example.OSAProjekat.repository.AdministratorRepository;
import com.example.OSAProjekat.repository.ProdavacRepository;
import com.example.OSAProjekat.service.AdministratorService;

@Service
public class AdministratorServiceImpl implements AdministratorService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AdministratorRepository adminRepo;
	
	@Override
	public List<Administrator> listAll() {
		return adminRepo.findAll();
	}

	@Override
	public Administrator save(Administrator administrator) {
		adminRepo.save(administrator);
		return administrator;
	}

	@Override
	public Administrator get(Integer id) {
		return adminRepo.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Administrator createAdministrator(AdministratorDTO administratorDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Administrator createeAdministrator(AdministratorDTO administratorDTO, KorisnikDTO korisnikDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
