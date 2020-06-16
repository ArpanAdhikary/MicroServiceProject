package com.cg.theater.dto;

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
@Table(name="theaterdb")
public class TheaterEntity {
	
	@Id
	@Column(name="theater_id")
	private Integer theaterId;
	@Column(name="theater_name")
	private String theaterName;
	@Column(name="movie_id")
	private Integer movieId;
	@Column(name="theater_city")
	private String theaterCity;
	@Column(name="manager_name")
	private String managerName;
	@Column(name="manager_contact")
	private String managerContact;
		
	public TheaterEntity() {
		super();
	}
	
	public TheaterEntity(Integer theaterId, String theaterName, Integer movieId, String theaterCity, String managerName,
			String managerContact) {
		super();
		this.theaterId = theaterId;
		this.theaterName = theaterName;
		this.movieId = movieId;
		this.theaterCity = theaterCity;
		this.managerName = managerName;
		this.managerContact = managerContact;
	}

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
	
			
	
