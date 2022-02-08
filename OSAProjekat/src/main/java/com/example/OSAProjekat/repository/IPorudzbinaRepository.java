package com.example.OSAProjekat.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.OSAProjekat.model.entity.ArtikalSearch;
import com.example.OSAProjekat.model.entity.Porudzbina;
import com.example.OSAProjekat.model.entity.PorudzbinaSearch;

@Repository
public interface IPorudzbinaRepository extends ElasticsearchRepository<PorudzbinaSearch, String> {

	List<PorudzbinaSearch> findAllByKomentar(String komentar);
	
	List<PorudzbinaSearch> findAll();
	
	List<PorudzbinaSearch> findByOcenaBetween(int minOcena, int maxOcena);
	
	List<PorudzbinaSearch> findAllByOcenaGreaterThan(int cena);
	
	List<PorudzbinaSearch> findAllByOcenaLessThan(int cena);
	
}
