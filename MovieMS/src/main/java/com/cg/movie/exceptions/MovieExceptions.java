package com.cg.movie.exceptions;

public class MovieExceptions extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer movieId;
	
	
	public MovieExceptions(Integer movieId) {
		super();
		this.movieId = movieId;
	}

	@Override
	public String toString() {
		String id=Integer.toString(movieId);
		if(movieId==0)
			return "MovieId cannot be 0";
		else if(id.charAt(0)!='3')
			return "MovieId should start with 3";
		else if(id.length()<4)
			return "MovieId should contain more than 4 digits";
		else
			return "Some other error occur please check the format before inserting";
	}
	
}
