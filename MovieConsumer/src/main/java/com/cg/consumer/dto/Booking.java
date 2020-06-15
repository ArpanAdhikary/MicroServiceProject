package com.cg.consumer.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.sun.istack.NotNull;

@Entity
@Table(name="booking")
public class Booking {

	@Id
	@NotNull
	@Column(name = "booking_id")
	private Integer bookingId;  
	
	@NotNull
	@Column(name = "movie_id")
	private Integer movieId;
	
	@NotNull
	@Column(name = "show_id")
	private Integer showId;
	
	
	@NotNull
	@Column(name = "booking_date")
	private LocalDate bookingDate;
	 
	@NotNull
	@Column(name = "total_Cost")
	private Double totalCost;
	
	public Booking(){
		
	}
	
	public Booking(Integer bookingId, Integer movieId, Integer showId, LocalDate bookingDate,
			Double totalCost) {
		super();
		this.bookingId = bookingId;
		this.movieId = movieId;
		this.showId = showId;
		this.bookingDate = bookingDate;
		this.totalCost = totalCost;
	}
	
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public Integer getShowId() {
		return showId;
	}
	public void setShowId(Integer showId) {
		this.showId = showId;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
	
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", movieId=" + movieId + ", showId=" + showId + ", bookingDate="
				+ bookingDate + ", totalCost=" + totalCost + "]";
	}
	
	
}
