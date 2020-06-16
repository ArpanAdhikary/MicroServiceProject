package com.cg.movie.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class Movie {
	
	private Integer movieId;
	private String movieName;
	private Date releaseDate;
	private Integer movieLength;
	private String movieGenre;
	private String movieDirector;
	
	private String language;
	
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Integer getMovieLength() {
		return movieLength;
	}
	public void setMovieLength(Integer movieLength) {
		this.movieLength = movieLength;
	}
	public String getMovieGenre() {
		return movieGenre;
	}
	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}
	public String getMovieDirector() {
		return movieDirector;
	}
	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public Movie(Integer movieId, String movieName, Date releaseDate, Integer movieLength, String movieGenre,
			String movieDirector, String language) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.releaseDate = releaseDate;
		this.movieLength = movieLength;
		this.movieGenre = movieGenre;
		this.movieDirector = movieDirector;
		this.language = language;
	}
	public Movie() {
		super();
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieLength=" + movieLength
				+ ", movieGenre=" + movieGenre + ", movieDirector=" + movieDirector + ", language=" + language
				+ ", releaseDate=" + releaseDate + "]";
	}
			

		}
