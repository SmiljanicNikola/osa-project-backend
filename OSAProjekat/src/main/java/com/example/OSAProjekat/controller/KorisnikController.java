package com.example.OSAProjekat.controller;

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
import com.example.OSAProjekat.model.entity.Korisnik;
import com.example.OSAProjekat.security.TokenUtils;
import com.example.OSAProjekat.service.KorisnikService;

@RestController
@RequestMapping("api/korisnici")
public class KorisnikController {
	
	@Autowired
    KorisnikService korisnikService;

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
