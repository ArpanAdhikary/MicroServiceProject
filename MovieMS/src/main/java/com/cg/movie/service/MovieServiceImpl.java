package com.cg.movie.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.movie.exceptions.MovieExceptions;
import com.cg.movie.dao.MovieDao;
import com.cg.movie.dto.MovieEntity;
import com.cg.movie.model.Movie;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	MovieDao dao;
	Logger logger = Logger.getLogger(MovieServiceImpl.class.getName());
	boolean result;
	Movie movie = new Movie();
	
	public Movie getMovie(Integer movieId){
		if(validateMovie(movieId)) {
			movie= dao.getMovie(movieId);
			return movie;
		}
		else
			return null;
	}
	
	public List<Movie> getMovieByMovieName(String movieName){
		if(movieName.isEmpty()||movieName.equals(""))
			return null;
		else
		{
			List<Movie> movie= dao.getMovieByMovieName(movieName);
			return movie;
		}
	}
	
	@Override
	public Boolean deleteMovie(Integer movieId) {
		if(validateMovie(movieId)) {
			logger.info("Deletion of Movie will take place");
			result=dao.deleteMovie(movieId);
			return result;
		}
		else {
			return false;
		}
		
	}
	
	@Override
	public Boolean updateMovie(Integer movieId,MovieEntity movie) {
		if(validateMovie(movieId)) {
			logger.info("Updation of Theater will take place");
			result=dao.updateMovie(movieId,movie);
			return result;
		}
		else
		{
			return false;
		}
	}

	@Override
	public Boolean addMovie(MovieEntity movie) {
		if(validateMovie(movie.getMovieId())) {
		logger.info("Updation of Theater will take place");
		result=dao.addMovie(movie);
		return result;
	}
	else
	{
		return false;
	}
	}

	public Boolean validateMovie(Integer movieId) {
		try {
			logger.info("Critical validation will take place");
		
			String id=Integer.toString(movieId);
			if(movieId!=0 ) {
				if(id.charAt(0)=='3') {
					if(id.length()>=4) {
						return true;
					}
					else {
						throw new MovieExceptions(movieId);
					}
				}
				else {
					throw new MovieExceptions(movieId);			
				}
			}
			else {
				throw new MovieExceptions(movieId);
			}	
		}
		catch(NullPointerException e) {
			logger.info("Null value Entered");
			System.out.println("Data cannot be null");
			return false;
		}
		catch(MovieExceptions e) {
			System.out.println(e);
			return false;
		}
	}

	

}
