package com.example.OSAProjekat.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OSAProjekat.model.entity.Korisnik;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Integer> {
	
	  Optional<Korisnik> findFirstByUsername(String username);

}
