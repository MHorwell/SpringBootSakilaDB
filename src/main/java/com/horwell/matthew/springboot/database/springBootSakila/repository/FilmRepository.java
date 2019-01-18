package com.horwell.matthew.springboot.database.springBootSakila.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.horwell.matthew.springboot.database.springBootSakila.model.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film,Long> {
	
	List<Film> findByTitle(String title);

}

