package com.xuechong.learn.refactoring.code.chap1.sec1;

/**
 * 租凭[表示某个顾客租了一部影片]
 * @author xuechong
 */
public class Rental {
	
	private Movie movie;
	private int daysRented;
	public Rental(Movie movie, int daysRented) {
		super();
		this.movie = movie;
		this.daysRented = daysRented;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public int getDaysRented() {
		return daysRented;
	}
	public void setDaysRented(int daysRented) {
		this.daysRented = daysRented;
	}
	
	
}
