package com.cg.theater.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.cg.theater.dto.TheaterEntity;
import com.cg.theater.model.Theater;

public interface TheaterService {
	public Theater getTheater(Integer theaterId);
	public List<Theater> getTheaterByTheaterCity(String theaterCity);
	public Boolean deleteTheater(Integer theaterId);
	public Boolean updateTheater(Integer theaterId,TheaterEntity theater);
	public Boolean addTheater(@RequestBody TheaterEntity theater) ;
}
