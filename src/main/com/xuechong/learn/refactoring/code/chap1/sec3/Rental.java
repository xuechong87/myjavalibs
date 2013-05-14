package com.xuechong.learn.refactoring.code.chap1.sec3;

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
	
	
	public double getCharge(){
		double result = 0;
		switch (this.getMovie().getPriceCode()) {
		case Movie.REGULAR:
			result+=2;
			if(this.getDaysRented()>2){
				result+=(this.getDaysRented()-2)*1.5;
			}
			break;
		case Movie.NEW_RELEASE:
			result += this.getDaysRented()*3;
			break;
		case Movie.CHILDREN:
			result += 1.5;
			if(this.getDaysRented()>3){
				result+=(this.getDaysRented()-3)*1.5;
			}
			break;
		}
		return result;
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
