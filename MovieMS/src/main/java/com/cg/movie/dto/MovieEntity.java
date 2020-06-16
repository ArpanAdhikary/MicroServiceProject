package com.cg.movie.dto;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/* Movie Entity class for mapping with the table moviedb in database*/
@Entity
@Table(name="moviedb")
public class MovieEntity {
	
	
	@Id											/* @Id annotation for identification of primary key*/
	@Column(name="movie_id")
	private Integer movieId;
	@Temporal(TemporalType.DATE)
	@Column(name="release_date")
	private Date releaseDate;
	@Column(name="movie_name")
	private String movieName;
	
	@Column(name="movie_length")
	private Integer movieLength;
	@Column(name="movie_genre")
	private String movieGenre;
	@Column(name="movie_director")
	private String movieDirector;
	@Column(name="language")
	private String language;

	
	public MovieEntity() {
		super();
	}
	
	
	public MovieEntity(Integer movieId, String movieName, Integer movieLength, String movieGenre, String movieDirector,
			Date localDate, String language) {
		super();
		this.movieId = movieId;
		this.releaseDate = localDate;
		this.movieName = movieName;
		this.movieLength = movieLength;
		this.movieGenre = movieGenre;
		this.movieDirector = movieDirector;
		this.language = language;
	}

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
	@Override
	public String toString() {
		return "MovieEntity [movieId=" + movieId + ", movieName=" + movieName + ", movieLength=" + movieLength
				+ ", movieGenre=" + movieGenre + ", movieDirector=" + movieDirector + ", releaseDate=" + releaseDate
				+ ", language=" + language + "]";
	}
}
	
			
	
