package com.example.OSAProjekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OSAProjekat.model.entity.Prodavac;

@Repository
public interface ProdavacRepository extends JpaRepository<Prodavac, Integer> {

}
