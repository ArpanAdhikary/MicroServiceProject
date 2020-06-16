package com.cg.test;


import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.anything;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.misusing.MissingMethodInvocationException;
import org.mockito.exceptions.misusing.WrongTypeOfReturnValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.movie.dao.MovieDao;
import com.cg.movie.dto.MovieEntity;
import com.cg.movie.dto.MovieRepository;
import com.cg.movie.model.Movie;
import com.cg.movie.service.MovieServiceImpl;

import org.mockito.ArgumentMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=com.cg.test.MovieMSTest.class)
public class MovieMSTest {
	@InjectMocks
	MovieServiceImpl movieService;
	@MockBean
	MovieDao movieDao;
	@MockBean
	MovieRepository movieRepository;
	@Before
	public void setUp() {
		
		Date date=new Date("26-Jan-19");
		MovieEntity movieEntity=new MovieEntity(31430,"PK", 125, "Romantic", "Sujit",date,"Hindi");
		Optional<MovieEntity> optional=Optional.of(movieEntity);
		Movie movie = new Movie();
		movie.setMovieId(movieEntity.getMovieId());
		movie.setMovieName(movieEntity.getMovieName());
		movie.setMovieDirector(movieEntity.getMovieDirector());
		movie.setMovieGenre(movieEntity.getMovieGenre());
		movie.setMovieLength(movieEntity.getMovieLength());
		movie.setReleaseDate(movieEntity.getReleaseDate());
		movie.setLanguage(movieEntity.getLanguage());
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void contextLoads() {
	}
	@Test(expected=AssertionError.class)
	public void getTheaterNegetiveTest() {
		Integer movieId=31530;
		Date date=new Date("26-Jan-19");
		MovieEntity movieEntity=new MovieEntity(31430,"PK", 125, "Romantic", "Sujit",date,"Hindi");
		Optional<MovieEntity> optional=Optional.of(movieEntity);
		when(movieRepository.findById(movieId)).thenReturn(null);
		assertEquals("MovieId not found",movieService.getMovie(movieId));
	}
	@Test(expected=NullPointerException.class)
	public void createTheaterNegetiveTest() {
		Date date=new Date("26-Jan-2019");
		
		MovieEntity movie=new MovieEntity(31430,"PK", 125, "Romantic", "Sujit",date,"Hindi");
		when(movieService.addMovie(movie)).thenReturn(null);
		assertEquals(null,movieService.addMovie(movie));
	}
	@Test
	public void updateTheaterPositiveTest() {
		Integer movieId=31430;
		Date date=new Date("26-Jan-2019");
		
		MovieEntity movie=new MovieEntity(31430,"PK", 125, "Romantic", "Sujit",date,"Hindi");
		when(movieDao.updateMovie(movieId, movie)).thenReturn(true);
		assertTrue(movieService.updateMovie(movieId,movie));
	}
	@Test(expected=AssertionError.class)
	public void updateTheaterNegetivetiveTest() {
		Integer movieId=31430;
		Date date=new Date("20-Jan-26");
		
		MovieEntity movie=new MovieEntity(31430,"PK", 125, "Romantic", "Sujit",date,"Hindi");
		when(movieRepository.findById(movieId)).thenReturn(null);
		assertEquals(null,movieService.updateMovie(movieId, movie));
	}
	
	@Test
	public void deleteTheaterPositiveTest() {
		Integer movieId=31430;
		Date date=new Date("26-Jan-2019");
		
		MovieEntity movie=new MovieEntity(31430,"PK", 125, "Romantic", "Sujit",date,"Hindi");
		Optional<MovieEntity> optional=Optional.of(movie);
		when(movieRepository.findById(movieId)).thenReturn(optional);
		assertNotNull(movieService.deleteMovie(movieId));
	}
	
	@Test(expected=AssertionError.class)
	public void deleteMovieNegetiveTest() {
		Integer movieId=31450;
		when(movieRepository.findById(movieId)).thenReturn(null);
		assertEquals(null,movieService.deleteMovie(movieId));
	}
	@Test
	public void readMovieByMovieIdPositive() {
		Integer movieId=31430;
		String movieName="PK";
		Date date=new Date("20-Jan-27");
		
		MovieEntity movie=new MovieEntity(31430,"PK", 125, "Romantic", "Sujit",date,"Hindi");
		when(movieRepository.findAll()).thenReturn(Stream.of(movie).collect(Collectors.toList()));
		assertEquals(0,movieService.getMovieByMovieName(movieName).size());
	}
	@Test
	public void readShowByMovieIdNegetive() {
		Integer movieId=31530;
		String movieName="POK";
		Date date=new Date("26-Jan-20");
		MovieEntity movie=new MovieEntity(31430,"PK", 125, "Romantic", "Sujit",date,"Hindi");
		List<MovieEntity> s=new ArrayList<MovieEntity>();
		when(movieRepository.findAll()).thenReturn(s);
		assertEquals(0,movieService.getMovieByMovieName(movieName).size());
	}

	
}
