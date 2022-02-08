package com.example.OSAProjekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OSAProjekat.model.entity.Kupac;

@Repository
public interface KupacRepository extends JpaRepository<Kupac, Integer> {

	Kupac findByKorisnikUsername(String korisnikUsername);
}
