package com.cg.theater.controller;


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

import com.cg.theater.dao.TheaterDao;
import com.cg.theater.dto.TheaterEntity;
import com.cg.theater.model.Theater;
import com.cg.theater.service.TheaterService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;

@RestController
public class TheaterController {

	@Autowired
	TheaterService service;
	
	@PutMapping("/theater/update/{id}")
	public String updateTheater(@PathVariable(value="id") Integer theaterId,@RequestBody TheaterEntity theater) {
		if(service.updateTheater(theaterId,theater)) {
			return "Updation Successful";
		}
		else
		{
			return "Updation Failure";
		}
	}
	@DeleteMapping("/theater/delete/{id}")
	public ResponseEntity<String> deleteTheater(@PathVariable(value="id") Integer theaterId) {
		 if(service.deleteTheater(theaterId)) {
			 return ResponseEntity.ok("Theater Deleted Successful");
		 }
		 else {
			 return ResponseEntity.ok("Theater Deletion Unsuccessful");
		 }
	}
	@GetMapping("/theaters/{id}")
	public Theater getTheater(@PathVariable(value="id") Integer theaterId) {
		//System.out.println("Entered value"+movieId);
		return service.getTheater(theaterId); 
	}
	
	@GetMapping("/theater/{theaterCity}")
	public List<Theater> getTheaterByTheaterCity(@PathVariable(value="theaterCity") String theaterCity) {
		System.out.println("asdfg");
		return service.getTheaterByTheaterCity(theaterCity); 
	}
	@HystrixCommand(fallbackMethod = "fallbacked")
	@PostMapping("/theater")
	public String addTheater(@RequestBody TheaterEntity theater) {
		System.out.println("movie k andar");
		if(service.addTheater(theater)) {
			return "Theater is added successfully";
		}
		else
		{
			return "Theater Id not found or matched , Theater addition unsuccessful";
		}
	}
	public String fallbacked(@RequestBody TheaterEntity theater) {
		return "SERVER NOT FOUND";
	}
}

