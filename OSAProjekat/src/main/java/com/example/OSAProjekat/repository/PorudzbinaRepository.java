package com.example.OSAProjekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OSAProjekat.model.entity.Artikal;
import com.example.OSAProjekat.model.entity.Porudzbina;

@Repository
public interface PorudzbinaRepository extends JpaRepository<Porudzbina, Integer> {

}
