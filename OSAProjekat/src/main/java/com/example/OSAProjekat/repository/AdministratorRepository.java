package com.example.OSAProjekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OSAProjekat.model.entity.Administrator;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {

}
