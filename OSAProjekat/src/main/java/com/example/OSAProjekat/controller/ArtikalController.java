package com.example.OSAProjekat.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OSAProjekat.model.dto.ArtikalDTO;
import com.example.OSAProjekat.model.entity.Artikal;
import com.example.OSAProjekat.service.ArtikalService;

@RestController
@RequestMapping(value = "api/artikli")
public class ArtikalController {
	
	@Autowired
	private ArtikalService artikalService;
	
	
	@PreAuthorize("hasRole('KUPAC')")
	@GetMapping
	public ResponseEntity<List<ArtikalDTO>> getArtikle(){
		List<Artikal> artikli = artikalService.listAll();
		
		List<ArtikalDTO> artikliDTO = new ArrayList<>();
		for(Artikal a : artikli) {
			artikliDTO.add(new ArtikalDTO(a));
		}
		
		return new ResponseEntity<>(artikliDTO, HttpStatus.OK);
		
	}
	
	
	@GetMapping(value = "/{id}")
    public ResponseEntity<ArtikalDTO> getArtikal(@PathVariable("id") Integer id) {
        Artikal artikal = artikalService.get(id);
        if (artikal == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new ArtikalDTO(artikal), HttpStatus.OK);
    }
	
	 @PostMapping()
	 @Consumes("MediaType.APPLICATION_JSON")
	 @Produces("MediaType.APPLICATION_JSON")
	    public ResponseEntity<ArtikalDTO> saveArtikal(@RequestBody ArtikalDTO artikalDTO) {
	        Artikal artikal = new Artikal();
	        artikal.setNaziv(artikalDTO.getNaziv());
	        artikal.setOpis(artikalDTO.getOpis());
	        artikal.setCena(artikalDTO.getCena());
	        artikal.setPutanjaSlike(artikalDTO.getPutanjaSlike());

	        artikal = artikalService.save(artikal);
	        return new ResponseEntity<>(new ArtikalDTO(artikal), HttpStatus.CREATED);
	    }

	@PutMapping(value = "/{id}")
	@Consumes("MediaType.APPLICATION_JSON")
	@Produces("MediaType.APPLICATION_JSON")
	    public ResponseEntity<ArtikalDTO> updateArtikal(@RequestBody ArtikalDTO artikalDTO, @PathVariable("id") Integer id) {
	        // A product must exist
	        Artikal artikal = artikalService.get(id);

	        if (artikal == null) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }

	        artikal.setNaziv(artikalDTO.getNaziv());
	        artikal.setOpis(artikalDTO.getOpis());
	        artikal.setCena(artikalDTO.getCena());
	        artikal.setPutanjaSlike(artikalDTO.getPutanjaSlike());

	        artikal = artikalService.save(artikal);

	        return new ResponseEntity<>(new ArtikalDTO(artikal), HttpStatus.OK);
	    }

	 @DeleteMapping(value = "/{id}")
	 @Consumes("MediaType.APPLICATION_JSON")
	 @Produces("MediaType.APPLICATION_JSON")
	    public ResponseEntity<?> deleteArtikal(@PathVariable("id") Integer id) {
	        Artikal artikal = artikalService.get(id);
	        if (artikal != null) {
	        	artikalService.delete(id);
	            return new ResponseEntity<>(HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	
	

}
