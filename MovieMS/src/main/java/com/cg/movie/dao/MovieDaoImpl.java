package com.cg.movie.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.movie.dto.MovieEntity;
import com.cg.movie.dto.MovieRepository;
import com.cg.movie.model.Movie;

@Service
public class MovieDaoImpl implements MovieDao {

	 Logger logger = Logger.getLogger(MovieDaoImpl.class.getName());
	 Movie movie=new Movie();
	@Autowired
	MovieRepository repository;
	
		// Function to fetch record from database with the help of id 
		@Override
		public Movie getMovie(Integer movieId){
		MovieEntity ce = new MovieEntity();
		Optional<MovieEntity> movieEntity = repository.findById(movieId);
		ce=movieEntity.get();
				movie.setMovieId(ce.getMovieId());
				movie.setReleaseDate(ce.getReleaseDate());
				movie.setMovieName(ce.getMovieName());
				movie.setMovieDirector(ce.getMovieDirector());
				movie.setMovieGenre(ce.getMovieGenre());
				movie.setMovieLength(ce.getMovieLength());
				movie.setLanguage(ce.getLanguage());
				return movie;
	}
		
		/* Fetching a list of movie using movie name*/
		@Override
		public List<Movie> getMovieByMovieName(String movieName){
			List<Movie> movieList=new ArrayList<>();
		List<MovieEntity> movieEntity = repository.findAll();
		for(MovieEntity ce:movieEntity) {
			    if((ce.getMovieName()).equals(movieName)) {
				movie.setMovieId(ce.getMovieId());
				movie.setReleaseDate(ce.getReleaseDate());
				movie.setMovieName(ce.getMovieName());
				movie.setMovieDirector(ce.getMovieDirector());
				movie.setMovieGenre(ce.getMovieGenre());
				movie.setMovieLength(ce.getMovieLength());
				movie.setLanguage(ce.getLanguage());
				movieList.add(movie);
			    }
		}
		return movieList;
	}
		
		/* Deleting certain record from database using id*/
		@Override
		public Boolean deleteMovie(Integer movieId) {
			if(repository.existsById(movieId)) {
				repository.deleteById(movieId);
				return true;
			}
			else
				return false;
		}
		
		/* Updating details of movie for a specific movie id*/
		@Override
		public Boolean updateMovie(Integer movieId, MovieEntity movie) {
			Optional<MovieEntity> check = repository.findById(movieId);
			if(check.isPresent()) {
				repository.deleteById(movieId);
				repository.saveAndFlush(movie);
				return true;
			}
			else
			{
				return false;
			}
		}
		
		/* Adding new movie in the database*/
		@Override
		public Boolean addMovie(MovieEntity movies) {
			
		
			if(repository.existsById(movies.getMovieId())) {
				return false;
			}
			else {
				MovieEntity movie=new MovieEntity();
				Integer id = movies.getMovieId();
				
					 movie.setMovieId(id);
					 movie.setMovieName(movies.getMovieName());
					 movie.setMovieLength(movies.getMovieLength());
					 movie.setReleaseDate(movies.getReleaseDate());
					 movie.setLanguage(movies.getLanguage());
					 movie.setMovieGenre(movies.getMovieGenre());
					 movie.setMovieDirector(movies.getMovieDirector());
					 repository.saveAndFlush(movie);
					
			return true;
			}	
		}
}
 