package com.horwell.matthew.springboot.database.springBootSakila.model;

import java.io.Serializable;
import java.time.Year;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.horwell.matthew.springboot.database.springBootSakila.repository.FilmRepository;

@Entity
@Table(name = "film_list")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"last_update"}, allowGetters = true)
@DynamicInsert(true)
@DynamicUpdate(true)

public class Film {
	
	@Id
	@Column(name = "FID")
	private Long filmId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@NotBlank
	@Column(name = "category")
	private String category;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "length")
	private Integer length;
	
	@Column(name = "rating")
	private String rating;
	
	@Column(name = "actors")
	private String actors;
	
	public Film() {
		
	}
	
	public Film(Long id, String title, String description, String category, double price, Integer length, String rating, String actors) {
			this.filmId = id;
			this.title = title;
			this.description = description;
			this.category = category;
			this.price = price;
			this.length = length;
			this.rating = rating;
			this.actors = actors;
		}

	public Long getFilmId() {
		return filmId;
	}

	public void setFilmId(Long filmId) {
		this.filmId = filmId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}
	
	
	

}
