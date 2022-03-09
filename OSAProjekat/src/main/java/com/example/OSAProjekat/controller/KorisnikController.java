package com.example.OSAProjekat.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OSAProjekat.model.dto.AdministratorDTO;
import com.example.OSAProjekat.model.dto.KorisnikDTO;
import com.example.OSAProjekat.model.entity.Administrator;
import com.example.OSAProjekat.model.entity.Korisnik;
import com.example.OSAProjekat.model.entity.Kupac;
import com.example.OSAProjekat.model.entity.KupacSignUpRequest;
import com.example.OSAProjekat.model.entity.MessageResponse;
import com.example.OSAProjekat.model.entity.Prodavac;
import com.example.OSAProjekat.model.entity.ProdavacSignUpRequest;
import com.example.OSAProjekat.model.entity.Roles;
import com.example.OSAProjekat.repository.KorisnikRepository;
import com.example.OSAProjekat.repository.KupacRepository;
import com.example.OSAProjekat.repository.ProdavacRepository;
import com.example.OSAProjekat.security.TokenUtils;
import com.example.OSAProjekat.service.AdministratorService;
import com.example.OSAProjekat.service.KorisnikService;
import com.example.OSAProjekat.service.KupacService;
import com.example.OSAProjekat.service.ProdavacService;
import com.example.OSAProjekat.security.JWTResponse;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("api/korisnici")
public class KorisnikController {
	
	@Autowired
    KorisnikService korisnikService;
	
	@Autowired
    AdministratorService adminService;
	
	@Autowired
    KupacService kupacService;
	
	@Autowired
    ProdavacService prodavacService;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenUtils tokenUtils;
    
    @Autowired
    KorisnikRepository korisnikRepository;
    
    @Autowired
    ProdavacRepository prodavacRepository;
    
    @Autowired
    KupacRepository kupacRepository;

    
    @Autowired
	private PasswordEncoder passwordEncoder;
    
    @GetMapping
	public ResponseEntity<List<KorisnikDTO>> getKorisnike(){
		List<Korisnik> korisnici = korisnikService.listAll();
		
		List<KorisnikDTO> korisniciDTO = new ArrayList<>();
		for(Korisnik k : korisnici) {
			korisniciDTO.add(new KorisnikDTO(k));
		}
		
		return new ResponseEntity<>(korisniciDTO, HttpStatus.OK);
		
	}
    
    
    @PostMapping()
    public ResponseEntity<KorisnikDTO> create(@RequestBody @Validated KorisnikDTO newKorisnik){

        Korisnik createdKorisnik = korisnikService.createUser(newKorisnik);

        if(createdKorisnik == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
        KorisnikDTO korisnikDTO = new KorisnikDTO(createdKorisnik);

        return new ResponseEntity<>(korisnikDTO, HttpStatus.CREATED);
    }
    
  
    
    @PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Korisnik korisnik, 
			@PathVariable Integer id) {
		try {
			Korisnik existKorisnik = korisnikService.get(id);
			if(existKorisnik != null) {
				existKorisnik.setIme(korisnik.getIme());
				existKorisnik.setPrezime(korisnik.getPrezime());
				existKorisnik.setUsername(korisnik.getUsername());
				existKorisnik.setPassword(passwordEncoder.encode(korisnik.getPassword()));
				korisnikService.save(existKorisnik);
			}
		return new ResponseEntity<>(HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
    
    
    @PutMapping("/username/{userName}")
	public ResponseEntity<?> update(@RequestBody Korisnik korisnik, 
			@PathVariable String userName) {
		try {
			Korisnik existKorisnik = korisnikService.get(userName);
			if(existKorisnik != null) {
				existKorisnik.setIme(korisnik.getIme());
				existKorisnik.setPrezime(korisnik.getPrezime());
				existKorisnik.setUsername(korisnik.getUsername());
				//existKorisnik.setPassword(passwordEncoder.encode(korisnik.getPassword()));
				korisnikService.save(existKorisnik);
			}
		return new ResponseEntity<>(HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
    
    
    @PutMapping("updatePassword/username/{userName}")
	public ResponseEntity<?> updatePassword(@RequestBody Korisnik korisnik, 
			@PathVariable String userName) {
		try {
			Korisnik existKorisnik = korisnikService.get(userName);
			if(existKorisnik != null) {
				existKorisnik.setPassword(passwordEncoder.encode(korisnik.getPassword()));
				korisnikService.save(existKorisnik);
			}
		return new ResponseEntity<>(HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
    
    
    @PutMapping("/blokiraj/{id}")
	public ResponseEntity<?> blokiraj(@RequestBody Korisnik korisnik, 
			@PathVariable Integer id) {
		try {
			Korisnik existKorisnik = korisnikService.get(id);
			if(existKorisnik != null) {
				existKorisnik.setBlokiran(true);
		
				korisnikService.save(existKorisnik);
			}
		return new ResponseEntity<>(HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
    
    
    @GetMapping("/{id}")
	public ResponseEntity<Korisnik> find(@PathVariable Integer id){
		try {
			Korisnik korisnik = korisnikService.get(id);
			return new ResponseEntity<Korisnik>(korisnik, HttpStatus.OK);
			
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Korisnik>(HttpStatus.NOT_FOUND);
		}
	}
    
    
    @GetMapping("/username/{username}")
	public ResponseEntity<Korisnik> find(@PathVariable String username){
		try {
			Korisnik korisnik = korisnikService.findByUsername(username);
			return new ResponseEntity<Korisnik>(korisnik, HttpStatus.OK);
			
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Korisnik>(HttpStatus.NOT_FOUND);
		}
	}
    
    
    @PostMapping("/prodavac")
    @Consumes("MediaType.APPLICATION_JSON")
	@Produces("MediaType.APPLICATION_JSON")
	public ResponseEntity<?> registerProdavac(@Valid @RequestBody ProdavacSignUpRequest signUpRequest) {
    	
		if (korisnikRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}
		

		Korisnik korisnik = new Korisnik(signUpRequest.getIme(), signUpRequest.getPrezime(), signUpRequest.getUsername(), passwordEncoder.encode(signUpRequest.getPassword()));

		korisnik.setBlokiran(false);
		korisnik.setRole(Roles.PRODAVAC);
	
		korisnikRepository.save(korisnik);
		
		Prodavac prodavac = new Prodavac(signUpRequest.getPoslujeOd(), signUpRequest.getEmail(), signUpRequest.getAdresa(), signUpRequest.getNaziv());
		prodavac.setKorisnik(korisnik);
		
		System.out.println("Kreirano" + signUpRequest.getNaziv());
		prodavacRepository.save(prodavac);
		System.out.println("Krei");
		

		return ResponseEntity.ok("Prodavac registrovan uspesno!");
	}
    
    
    //Administrator se kreira iskljucivo u POSTMAN-u
    @PostMapping("/administrator")
    @Consumes("MediaType.APPLICATION_JSON")
	@Produces("MediaType.APPLICATION_JSON")
    public ResponseEntity<AdministratorDTO> createAdministrator(@RequestBody @Validated KorisnikDTO newKorisnik, AdministratorDTO newAdministrator){
         
        Administrator createdAdministrator = adminService.createAdministrator(newAdministrator, newKorisnik);

        if(createdAdministrator == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
        
        AdministratorDTO administratorDTO = new AdministratorDTO(createdAdministrator);
        //prodavacDTO.setId(newKorisnik.getId());

        return new ResponseEntity<>(administratorDTO, HttpStatus.CREATED);       
    }
    
    
    //Registracija kupca
    
    @PostMapping("/kupac")
    @Consumes("MediaType.APPLICATION_JSON")
	@Produces("MediaType.APPLICATION_JSON")
	public ResponseEntity<?> registerKupac(@Valid @RequestBody KupacSignUpRequest signUpRequest) {
		if (korisnikRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}
		

		Korisnik korisnik = new Korisnik(signUpRequest.getIme(), signUpRequest.getPrezime(), signUpRequest.getUsername(), passwordEncoder.encode(signUpRequest.getPassword()));

		korisnik.setBlokiran(false);
		korisnik.setRole(Roles.KUPAC);
	
		korisnikRepository.save(korisnik);
		
		Kupac kupac = new Kupac(signUpRequest.getAdresa());
		kupac.setKorisnik(korisnik);
		
		System.out.println("Kreirano" + signUpRequest.getAdresa());
		kupacRepository.save(kupac);
		System.out.println("Krei");
		

		return ResponseEntity.ok("Kupac registrovan uspesno!");
	}
    
    
  
    @PostMapping("/login")
    public ResponseEntity<JWTResponse> login(@RequestBody KorisnikDTO korisnikDTO) {
    	String userNameLogovanog = korisnikDTO.getUsername();
    	Korisnik korisnik = korisnikService.findByUsername(userNameLogovanog);
    	if(korisnik != null) {
    	if(!korisnik.isBlokiran()) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(korisnikDTO.getUsername(), korisnikDTO.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        try {
        	
            UserDetails userDetails = userDetailsService.loadUserByUsername(korisnikDTO.getUsername());
            String token = tokenUtils.generateToken(userDetails);
            //return ResponseEntity.ok(tokenUtils.generateToken(userDetails));
            return ResponseEntity.ok(new JWTResponse(token, 
   				 userDetails.getUsername()));
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }else {
    	return ResponseEntity.status(403).build();
    }
    }else {
    	return ResponseEntity.status(404).build();
    }
}
    
    @PostMapping("/login2")
    public ResponseEntity<String> login2(@RequestBody KorisnikDTO korisnikDTO) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(korisnikDTO.getUsername(), korisnikDTO.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(korisnikDTO.getUsername());
            return ResponseEntity.ok(tokenUtils.generateToken(userDetails));
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    

}
