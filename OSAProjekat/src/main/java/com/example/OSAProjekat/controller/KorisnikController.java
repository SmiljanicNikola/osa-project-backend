package com.example.OSAProjekat.controller;

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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OSAProjekat.model.dto.KorisnikDTO;
import com.example.OSAProjekat.model.dto.ProdavacDTO;
import com.example.OSAProjekat.model.entity.Korisnik;
import com.example.OSAProjekat.model.entity.Prodavac;
import com.example.OSAProjekat.security.TokenUtils;
import com.example.OSAProjekat.service.KorisnikService;
import com.example.OSAProjekat.service.ProdavacService;

@RestController
@RequestMapping("api/korisnici")
public class KorisnikController {
	
	@Autowired
    KorisnikService korisnikService;
	
	@Autowired
    ProdavacService prodavacService;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenUtils tokenUtils;
    
    @PostMapping()
    public ResponseEntity<KorisnikDTO> create(@RequestBody @Validated KorisnikDTO newKorisnik){

        Korisnik createdKorisnik = korisnikService.createUser(newKorisnik);

        if(createdKorisnik == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
        KorisnikDTO korisnikDTO = new KorisnikDTO(createdKorisnik);

        return new ResponseEntity<>(korisnikDTO, HttpStatus.CREATED);
    }
    
    @PostMapping("/prodavac")
    @Consumes("MediaType.APPLICATION_JSON")
	@Produces("MediaType.APPLICATION_JSON")
    public ResponseEntity<ProdavacDTO> createProdavac(@RequestBody @Validated KorisnikDTO newKorisnik, ProdavacDTO newProdavac){

        /*Korisnik createdKorisnik = korisnikService.createProdavac(newKorisnik);

        if(createdKorisnik == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
        KorisnikDTO korisnikDTO = new KorisnikDTO(createdKorisnik);*/

       
        
        
        Prodavac createdProdavac = prodavacService.createeProdavac(newProdavac, newKorisnik);

        if(createdProdavac == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
        
        ProdavacDTO prodavacDTO = new ProdavacDTO(createdProdavac);
        //prodavacDTO.setId(newKorisnik.getId());

        return new ResponseEntity<>(prodavacDTO, HttpStatus.CREATED);
        
        
        
        
    }
    
    
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody KorisnikDTO korisnikDTO) {
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
