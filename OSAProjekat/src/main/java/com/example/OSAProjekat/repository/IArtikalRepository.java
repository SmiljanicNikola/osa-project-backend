package com.example.OSAProjekat.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.OSAProjekat.model.entity.ArtikalSearch;
import com.example.OSAProjekat.model.entity.PorudzbinaSearch;

@Repository
public interface IArtikalRepository extends ElasticsearchRepository<ArtikalSearch, String> {

	List<ArtikalSearch> findAllByNaziv(String naziv);
	
	List<ArtikalSearch> findAll();
	
	List<ArtikalSearch> findAllByCenaGreaterThan(int cena);
	
	List<ArtikalSearch> findAllByCenaLessThan(int cena);
	
	List<ArtikalSearch> findByCenaBetween(double minCena, int maxCena);

	
}
