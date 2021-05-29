package com.example.OSAProjekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OSAProjekat.model.entity.Artikal;

@Repository
public interface ArtikalRepository extends JpaRepository<Artikal, Integer> {

}
