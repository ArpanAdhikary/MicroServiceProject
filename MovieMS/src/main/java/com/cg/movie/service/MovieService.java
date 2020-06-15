package com.cg.movie.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.cg.movie.dto.MovieEntity;
import com.cg.movie.model.Movie;

public interface MovieService {
	public Movie getMovie(Integer movieId);
	public List<Movie> getMovieByMovieName(String movieName);
	public Boolean deleteMovie(Integer movieId);
	public Boolean updateMovie(Integer movieId,MovieEntity movie);
	public Boolean addMovie(@RequestBody MovieEntity movie) ;
}
