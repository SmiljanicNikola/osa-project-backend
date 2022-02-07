package com.example.OSAProjekat.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.OSAProjekat.model.entity.ArtikalSearch;

@Repository
public interface IArtikalRepository extends ElasticsearchRepository<ArtikalSearch, String> {

	List<ArtikalSearch> findAllByNaziv(String naziv);
	
	List<ArtikalSearch> findAll();
	
}
