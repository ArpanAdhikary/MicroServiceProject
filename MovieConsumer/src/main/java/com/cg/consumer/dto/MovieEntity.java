package com.cg.consumer.dto;

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

@Entity
@Table(name="moviedb")
public class MovieEntity {
	
	@Id
	@Column(name="movie_id")
	private Integer movieId;
	@Column(name="movie_name")
	private String movieName;
	@Column(name="movie_length")
	private Integer movieLength;
	@Column(name="movie_genre")
	private String movieGenre;
	@Column(name="movie_director")
	private String movieDirector;
	@Column(name="release_date")
	@Temporal(TemporalType.DATE)
	private Date releaseDate;
	@Column(name="language")
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
	@Override
	public String toString() {
		return "MovieEntity [movieId=" + movieId + ", movieName=" + movieName + ", movieLength=" + movieLength
				+ ", movieGenre=" + movieGenre + ", movieDirector=" + movieDirector + ", releaseDate=" + releaseDate
				+ ", language=" + language + "]";
	}
	
}
	
			
	
