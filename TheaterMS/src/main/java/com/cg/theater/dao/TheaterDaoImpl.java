package com.cg.theater.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.theater.dto.TheaterEntity;
import com.cg.theater.dto.TheaterRepository;
import com.cg.theater.model.Theater;

@Service
public class TheaterDaoImpl implements TheaterDao {

	 Logger logger = Logger.getLogger(TheaterDaoImpl.class.getName());
	 Theater theater=new Theater();
	@Autowired
	TheaterRepository repository;
	
		public Theater getTheater(Integer theaterId){
		TheaterEntity ce = new TheaterEntity();
		Optional<TheaterEntity> theaterEntity = repository.findById(theaterId);
		ce=theaterEntity.get();
				theater.setTheaterId(ce.getTheaterId());
				theater.setTheaterName(ce.getTheaterName());
				theater.setMovieId(ce.getMovieId());
				theater.setTheaterCity(ce.getTheaterCity());
				theater.setManagerContact(ce.getManagerContact());
				theater.setManagerName(ce.getManagerName());
				return theater;
	}
		public List<Theater> getTheaterByTheaterCity(String theaterCity){
			List<Theater> theaterList=new ArrayList<>();
		List<TheaterEntity> theaterEntity = repository.findAll();
		for(TheaterEntity ce:theaterEntity) {
			System.out.println(ce);
			Theater theaters=new Theater();
			    if((ce.getTheaterCity()).equals(theaterCity)) {
			    	System.out.println(theaterCity);
			    	theaters.setTheaterId(ce.getTheaterId());
					theaters.setTheaterName(ce.getTheaterName());
					theaters.setMovieId(ce.getMovieId());
					theaters.setTheaterCity(ce.getTheaterCity());
					theaters.setManagerContact(ce.getManagerContact());
					theaters.setManagerName(ce.getManagerName());
					theaterList.add(theaters);
			    }
		}
		return theaterList;
	}
		@Override
		public Boolean deleteTheater(Integer theaterId) {
			if(repository.existsById(theaterId)) {
				repository.deleteById(theaterId);
				return true;
			}
			else
				return false;
		}
		@Override
		public Boolean updateTheater(Integer theaterId, TheaterEntity theater) {
			Optional<TheaterEntity> check = repository.findById(theaterId);
			if(check.isPresent()) {
				repository.deleteById(theaterId);
				repository.saveAndFlush(theater);
				return true;
			}
			else
			{
				return false;
			}
		}
		@Override
		public Boolean addTheater(TheaterEntity theaters) {
			
			if(repository.existsById(theaters.getTheaterId())) {
				return false;
			}
			else {
				TheaterEntity theater=new TheaterEntity();
				Integer id = theaters.getTheaterId();
				id=id-1;
				String[] arr = new String[1];
				//for(String lang:movies.getLanguage()) {
				theater.setTheaterId(id+1);
				theater.setTheaterName(theaters.getTheaterName());
				theater.setMovieId(theaters.getMovieId());
				theater.setTheaterCity(theaters.getTheaterCity());
				theater.setManagerContact(theaters.getManagerContact());
				theater.setManagerName(theaters.getManagerName());
				repository.saveAndFlush(theater);
					//}
			return true;
			}	
		}
}
 