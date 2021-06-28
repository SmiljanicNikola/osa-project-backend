package com.example.OSAProjekat.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.OSAProjekat.model.entity.Korisnik;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Integer> {
	
	  Optional<Korisnik> findFirstByUsername(String username);
	  
	  /*@Query(value = "SELECT u FROM User u WHERE u.username = :username")
		User getUserByUsername(@Param("username") String username);

		
		User findByUsername(String username);
		
		Boolean existsByUsername(String username);*/

}
