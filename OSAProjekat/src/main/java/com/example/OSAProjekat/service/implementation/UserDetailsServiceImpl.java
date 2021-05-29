package com.example.OSAProjekat.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.OSAProjekat.model.entity.Korisnik;
import com.example.OSAProjekat.service.KorisnikService;

@Service
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
    private KorisnikService korisnikService;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Korisnik korisnik = korisnikService.findByUsername(username);

        if(korisnik == null){
            throw new UsernameNotFoundException("Nema korisnika sa tim korisnickim imenom " + username);
        }else{
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            String role = "ROLE_" + korisnik.getRole().toString();
            grantedAuthorities.add(new SimpleGrantedAuthority(role));

            return new org.springframework.security.core.userdetails.User(
                    korisnik.getUsername().trim(),
                    korisnik.getPassword().trim(),
                    grantedAuthorities);
        }
	}

}
