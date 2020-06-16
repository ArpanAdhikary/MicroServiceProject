package com.cg.movie.controller;


import java.util.ArrayList;
import java.util.List;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.movie.dao.MovieDao;
import com.cg.movie.dto.MovieEntity;
import com.cg.movie.dto.MovieRepository;
import com.cg.movie.model.Movie;
import com.cg.movie.service.MovieService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;

@RestController
public class MovieController {

	@Autowired
	MovieService service;
	
	@Autowired
	MovieRepository repo;
	
	@PutMapping("/movie/update/{id}")
	public String updateMovie(@PathVariable(value="id") Integer movieId,@RequestBody MovieEntity movie) {
		if(movieId==null||movieId==0)
			return "Movie Id should be entered";
		if(service.updateMovie(movieId,movie)) {
			return "Movie Updation Successful";
		}
		else
		{
			return "Updation Failure,Please check the Movie ID it may be absent or not in correct format";
		}
	}
	@DeleteMapping("/movie/delete/{id}")
	public ResponseEntity<String> deleteMovie(@PathVariable(value="id") Integer movieId) {
		if(movieId==null||movieId==0)
			return ResponseEntity.ok("Movie Id should be entered"); 
		if(service.deleteMovie(movieId)) {
			 return ResponseEntity.ok("Movie Deleted Successful");
		 }
		 else {
			 return ResponseEntity.ok("Movie Deletion Unsuccessful");
		 }
	}
	@GetMapping("/movies/{id}")
	public Movie getMovie(@PathVariable(value="id") Integer movieId) {
		//System.out.println("Entered value"+movieId);
		if(movieId==null||movieId==0)
			return new Movie(0,"Movie Id should not be null or zero", null, movieId, "null", null, null); 
		if(repo.existsById(movieId)==false)
			return new Movie(0,"Movie Id doesnot exist", null, movieId, null, null, null);
		
		return service.getMovie(movieId); 
	}
	
	@GetMapping("/movie/{name}")
	public List<Movie> getMovieByMovieName(@PathVariable(value="name") String movieName) {
		//System.out.println("asdfg");
		List<Movie> list =new ArrayList<>();
		list=service.getMovieByMovieName(movieName);
		if(list.size()==0) {
			Movie mv =new Movie(0,"Movie Id doesnot exist", null, 0, null, null, null);
			list.add(mv);
			return list;
		}
		return list;  
	}
	@HystrixCommand(fallbackMethod = "fallbacked")
	@PostMapping("/movie")
	public String addMovie(@RequestBody MovieEntity movie) {
		System.out.println("movie k andar");
		if(service.addMovie(movie)) {
			return "Movie is added successfully";
		}
		else
		{
			return "Movie Id not found or format not matched , Movie addition unsuccessful";
		}
	}
	public String fallbacked(@RequestBody MovieEntity movie) {
		return "SERVER NOT FOUND";
	}
}

