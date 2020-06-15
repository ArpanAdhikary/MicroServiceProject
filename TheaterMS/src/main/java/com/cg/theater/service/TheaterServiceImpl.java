package com.cg.theater.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.theater.dao.TheaterDao;
import com.cg.theater.dto.TheaterEntity;
import com.cg.theater.exceptions.TheaterExceptions;
import com.cg.theater.model.Theater;

@Service
public class TheaterServiceImpl implements TheaterService {
	
	@Autowired
	TheaterDao dao;
	Logger logger = Logger.getLogger(TheaterServiceImpl.class.getName());
	boolean result;
	Theater theater = new Theater();
	
	public Theater getTheater(Integer theaterId){
		if(validateTheater(theaterId)) {
			theater= dao.getTheater(theaterId);
			return theater;
		}
		else
			return null;
	}
	
	public List<Theater> getTheaterByTheaterCity(String theaterCity){
		if(theaterCity.isEmpty()||theaterCity.equals(""))
			return null;
		else
		{
			List<Theater> theater= dao.getTheaterByTheaterCity(theaterCity);
			return theater;
		}
	}
	
	@Override
	public Boolean deleteTheater(Integer theaterId) {
		if(validateTheater(theaterId)) {
			logger.info("Deletion of Theater will take place");
			result=dao.deleteTheater(theaterId);
			return result;
		}
		else {
			return false;
		}
		
	}
	
	@Override
	public Boolean updateTheater(Integer theaterId,TheaterEntity theater) {
		if(validateTheater(theaterId)) {
			logger.info("Updation of Theater will take place");
			result=dao.updateTheater(theaterId,theater);
			return result;
		}
		else
		{
			return false;
		}
	}

	@Override
	public Boolean addTheater(TheaterEntity theater) {
		if(validateTheater(theater.getTheaterId())) {
		logger.info("Updation of Theater will take place");
		result=dao.addTheater(theater);
		return result;
	}
	else
	{
		return false;
	}
	}

	public Boolean validateTheater(Integer theaterId) {
		try {
			logger.info("Critical validation will take place");
		
			String id=Integer.toString(theaterId);
			if(theaterId!=0 ) {
				if(id.charAt(0)=='2') {
					if(id.length()>=4) {
						return true;
					}
					else {
						throw new TheaterExceptions(theaterId);
					}
				}
				else {
					throw new TheaterExceptions(theaterId);			
				}
			}
			else {
				throw new TheaterExceptions(theaterId);
			}	
		}
		catch(NullPointerException e) {
			logger.info("Null value Entered");
			System.out.println("Data cannot be null");
			return false;
		}
		catch(TheaterExceptions e) {
			System.out.println(e);
			return false;
		}
	}

	

}
