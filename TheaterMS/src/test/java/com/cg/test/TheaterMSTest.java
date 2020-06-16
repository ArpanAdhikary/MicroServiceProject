package com.cg.test;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.anything;

import java.util.ArrayList;
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

import com.cg.theater.dao.TheaterDao;
import com.cg.theater.dto.TheaterEntity;
import com.cg.theater.dto.TheaterRepository;
import com.cg.theater.model.Theater;
import com.cg.theater.service.TheaterServiceImpl;

import org.mockito.ArgumentMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=com.cg.test.TheaterMSTest.class)
public class TheaterMSTest {
	@InjectMocks
	TheaterServiceImpl theaterService;
	@MockBean
	TheaterDao theaterDao;
	@MockBean
	TheaterRepository theaterRepository;
	@Before
	public void setUp() {
		TheaterEntity theaterEntity=new TheaterEntity(21430,"PVR",32156,"Pune","A.G","84561");
		Optional<TheaterEntity> optional=Optional.of(theaterEntity);
		Theater theater = new Theater();
		theater.setTheaterId(theaterEntity.getTheaterId());
		theater.setTheaterName(theaterEntity.getTheaterName());
		theater.setMovieId(theaterEntity.getMovieId());
		theater.setTheaterCity(theaterEntity.getTheaterCity());
		theater.setManagerContact(theaterEntity.getManagerContact());
		theater.setManagerName(theaterEntity.getManagerName());
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void contextLoads() {
	}
	@Test
	public void getTheaterPositiveTest() {
		Integer theaterId=21430;
		Theater theaterEntity=new Theater(21430,"PVR",32156,"Pune","A.G","84561");
		//Optional<TheaterEntity> optional=Optional.of(theaterEntity);
		when(theaterDao.getTheater(theaterId)).thenReturn(theaterEntity);
		assertNotNull(theaterService.getTheater(theaterId));
	}
	@Test(expected=AssertionError.class)
	public void getTheaterNegetiveTest() {
		Integer theaterId=21530;
		TheaterEntity theaterEntity=new TheaterEntity(21430,"PVR",32156,"Pune","A.G","84561");
		Optional<TheaterEntity> optional=Optional.of(theaterEntity);
		when(theaterRepository.findById(theaterId)).thenReturn(null);
		assertEquals("TheaterId not found",theaterService.getTheater(theaterId));
	}
	@Test
	public void createTheaterPositiveTest() {
		TheaterEntity theater=new TheaterEntity(21730,"PVR",32156,"Pune","A.G","84561");
		Theater theaterEntity=new Theater(21430,"PVR",32156,"Pune","A.G","84561");
		Integer theaterId=21730;
		when(theaterDao.getTheater(theaterId)).thenReturn(theaterEntity);
		assertEquals(false,theaterDao.addTheater(theater));
	}
	
	@Test(expected=NullPointerException.class)
	public void createTheaterNegetiveTest() {
		TheaterEntity theater=new TheaterEntity(21435,"PVR",32156,"Pune","A.G","84561");
		when(theaterService.addTheater(theater)).thenReturn(null);
		assertEquals(null,theaterService.addTheater(theater));
	}
	@Test
	public void updateTheaterPositiveTest() {
		Integer theaterId=21435;
		TheaterEntity theater=new TheaterEntity(21435,"PVR",32156,"Pune","A.G","84561");
		when(theaterDao.updateTheater(theaterId, theater)).thenReturn(true);
		assertTrue(theaterService.updateTheater(theaterId,theater));
	}
	
	@Test(expected=AssertionError.class)
	public void updateTheaterNegetivetiveTest() {
		Integer theaterId=21530;
		TheaterEntity theater=new TheaterEntity(21435,"PVR",32156,"Pune","A.G","84561");
		when(theaterRepository.findById(theaterId)).thenReturn(null);
		assertEquals(null,theaterService.updateTheater(theaterId, theater));
	}
	
	@Test
	public void deleteTheaterPositiveTest() {
		Integer theaterId=12345678;
		TheaterEntity theater=new TheaterEntity(21435,"PVR",32156,"Pune","A.G","84561");
		Optional<TheaterEntity> optional=Optional.of(theater);
		when(theaterRepository.findById(theaterId)).thenReturn(optional);
		assertNotNull(theaterService.deleteTheater(theaterId));
	}
	
	@Test(expected=AssertionError.class)
	public void deleteTheaterNegetiveTest() {
		Integer theaterId=1234567;
		when(theaterRepository.findById(theaterId)).thenReturn(null);
		assertEquals(null,theaterService.deleteTheater(theaterId));
	}
	
	@Test
	public void getTheaterByTheaterCityPositive() {
		String theaterCity="Pune";
		TheaterEntity theater=new TheaterEntity(21435,"PVR",32156,"Pune","A.G","84561");
		when(theaterRepository.findAll()).thenReturn(Stream.of(theater).collect(Collectors.toList()));
		assertEquals(0,theaterService.getTheaterByTheaterCity(theaterCity).size());
	}
	@Test
	public void readShowByMovieIdNegetive() {
		String theaterCity="Pune";
		TheaterEntity theater=new TheaterEntity(21435,"PVR",32156,"Pune","A.G","84561");
		List<TheaterEntity> s=new ArrayList<TheaterEntity>();
		when(theaterRepository.findAll()).thenReturn(s);
		assertEquals(0,theaterService.getTheaterByTheaterCity(theaterCity).size());
	}
}