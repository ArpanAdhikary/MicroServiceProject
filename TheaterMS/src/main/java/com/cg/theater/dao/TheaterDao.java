package com.cg.theater.dao;

import java.util.Date;
import java.util.List;

import com.cg.theater.dto.TheaterEntity;
import com.cg.theater.model.Theater;


public interface TheaterDao {
	
	public Theater getTheater(Integer theaterId);
	public List<Theater> getTheaterByTheaterCity(String theaterCity);
	public Boolean deleteTheater(Integer theaterId);
	public Boolean updateTheater(Integer theaterId,TheaterEntity theater);
	public Boolean addTheater(TheaterEntity movie);
}
