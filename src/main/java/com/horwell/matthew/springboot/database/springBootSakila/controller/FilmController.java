package com.horwell.matthew.springboot.database.springBootSakila.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.horwell.matthew.springboot.database.springBootSakila.exception.ResourceNotFoundException;
import com.horwell.matthew.springboot.database.springBootSakila.model.Film;
import com.horwell.matthew.springboot.database.springBootSakila.repository.FilmRepository;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class FilmController {
	
	@Autowired
	FilmRepository repository;
	
	@PostMapping("/film")
	public Film createFilm(@Valid @RequestBody Film sDGM) {
		return repository.save(sDGM);
	}
	
	@GetMapping("/film/{id}")
	public Film getFilmByID(@PathVariable(value = "id")Long filmId) {
		return repository.findById(filmId)
				.orElseThrow(()-> new ResourceNotFoundException("SpringBootDatabase","id",filmId));
	}
	
   @GetMapping("/film/title/{title}")
    public List<Film> findByColour(@PathVariable(value = "title")String filmTitle) {
        return repository.findByTitle(filmTitle);
    }
	
   	@CrossOrigin
	@GetMapping("/film")
	public List<Film> getAllFilms(){
		return repository.findAll();
	}
//	
//	@PutMapping("/vehicle/{id}")
//	public Vehicle updateVehicle(@PathVariable(value = "id") Long vehicleID,
//			@Valid @RequestBody Vehicle vehicleDetails) {
//		Vehicle sDGM = repository.findById(vehicleID)
//				.orElseThrow(()-> new ResourceNotFoundException("Vehicle","id",vehicleID));
//		
//		if (vehicleDetails.getType() == null){
//			vehicleDetails.setType(sDGM.getType());
//		}
//		if (vehicleDetails.getManufacturer() == null){
//			vehicleDetails.setManufacturer(sDGM.getManufacturer());
//		}
//		if (vehicleDetails.getModel() == null){
//			vehicleDetails.setModel(sDGM.getModel());
//		}
//		if (vehicleDetails.getColour() == null) {
//			vehicleDetails.setColour(sDGM.getColour());
//		}
//		if (vehicleDetails.getYearMade() == 0) {
//			vehicleDetails.setYearMade(sDGM.getYearMade());
//		}
//		
//		sDGM.setType(vehicleDetails.getType());
//		sDGM.setManufacturer(vehicleDetails.getManufacturer());
//		sDGM.setModel(vehicleDetails.getModel());
//		sDGM.setColour(vehicleDetails.getColour());
//		sDGM.setYearMade(vehicleDetails.getYearMade());
//		
//		
//		return repository.save(sDGM);
//	}
//	
//	@DeleteMapping("/vehicle/{id}")
//	public ResponseEntity<?> deleteVehicle(@PathVariable(value = "id")Long vehicleID){
//		Vehicle sDGM = repository.findById(vehicleID)
//				.orElseThrow(()-> new ResourceNotFoundException("Vehicle","id",vehicleID));
//		repository.delete(sDGM);
//		return ResponseEntity.ok().build();
//	}

}
