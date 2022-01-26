package com.example.OSAProjekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OSAProjekat.model.entity.Artikal;
import com.example.OSAProjekat.model.entity.Stavka;

@Repository
public interface StavkaRepository extends JpaRepository<Stavka, Integer> {

}
