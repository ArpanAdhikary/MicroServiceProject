package com.cg.movie.dao;

import java.util.Date;
import java.util.List;

import com.cg.movie.dto.MovieEntity;
import com.cg.movie.model.Movie;


public interface MovieDao {
	
	public Movie getMovie(Integer movieId);
	public List<Movie> getMovieByMovieName(String movieName);
	public Boolean deleteMovie(Integer movieId);
	public Boolean updateMovie(Integer movieId,MovieEntity movie);
	public Boolean addMovie(MovieEntity movie);
}
