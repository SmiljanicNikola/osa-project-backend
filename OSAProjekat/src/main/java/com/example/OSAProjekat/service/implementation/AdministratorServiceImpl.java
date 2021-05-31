package com.example.OSAProjekat.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.OSAProjekat.model.dto.AdministratorDTO;
import com.example.OSAProjekat.model.dto.KorisnikDTO;
import com.example.OSAProjekat.model.dto.ProdavacDTO;
import com.example.OSAProjekat.model.entity.Administrator;
import com.example.OSAProjekat.model.entity.Korisnik;
import com.example.OSAProjekat.model.entity.Roles;
import com.example.OSAProjekat.repository.AdministratorRepository;
import com.example.OSAProjekat.repository.KorisnikRepository;
import com.example.OSAProjekat.service.AdministratorService;

@Service
public class AdministratorServiceImpl implements AdministratorService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private KorisnikRepository korisnikRepo;
	
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

	public Administrator createAdministrator(AdministratorDTO administratorDTO, KorisnikDTO korisnikDTO) {
		
		//Sam korisnik
	 	Korisnik newKorisnik = new Korisnik();
	 	//newKorisnik.setId(korisnikDTO.getId());
        newKorisnik.setIme(korisnikDTO.getIme());
        newKorisnik.setPrezime(korisnikDTO.getPrezime());
        newKorisnik.setUsername(korisnikDTO.getUsername());
        newKorisnik.setPassword(passwordEncoder.encode(korisnikDTO.getPassword()));
        newKorisnik.setBlokiran(false);
        newKorisnik.setRole(Roles.ADMINISTRATOR);
        newKorisnik = korisnikRepo.save(newKorisnik);
	
        //Sam prodavac
	 	Administrator newAdministrator = new Administrator();
	 	//newProdavac.setId(newKorisnik.getId());
	 	newAdministrator.setKorisnik(newKorisnik);
	 	
	 	newAdministrator = adminRepo.save(newAdministrator);

        return newAdministrator;
}

	/*@Override
	public Administrator createeAdministrator(AdministratorDTO administratorDTO, KorisnikDTO korisnikDTO) {
		// TODO Auto-generated method stub
		return null;
	}*/

}
