package com.cg.consumer.model;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class Theater {
	
	private Integer theaterId;
	private String theaterName;
	/*private Integer movieLength;
	private String movieGenre;
	private String movieDirector;
	private Date releaseDate;
	private String language;*/
	private Integer movieId;
	private String theaterCity;
	private String managerName;
	private String managerContact;
		
	public Integer getTheaterId() {
		return theaterId;
	}
	public void setTheaterId(Integer theaterId) {
		this.theaterId = theaterId;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public String getTheaterCity() {
		return theaterCity;
	}
	public void setTheaterCity(String theaterCity) {
		this.theaterCity = theaterCity;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerContact() {
		return managerContact;
	}
	public void setManagerContact(String managerContact) {
		this.managerContact = managerContact;
	}
	@Override
	public String toString() {
		return "TheaterEntity [theaterId=" + theaterId + ", theaterName=" + theaterName + ", movieId=" + movieId
				+ ", theaterCity=" + theaterCity + ", managerName=" + managerName + ", managerContact=" + managerContact
				+ "]";
	}
	
	
		}
