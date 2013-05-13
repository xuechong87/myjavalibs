package com.xuechong.learn.refactoring.code.chap1.sec1;

public class Movie {
	public static final int CHILDREN = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE =1;
	
	private String _title;
	private int _priceCode;
	public Movie(String title, int priceCode) {
		super();
		_title = title;
		_priceCode = priceCode;
	}
	public String getTitle() {
		return _title;
	}
	public void setTitle(String title) {
		_title = title;
	}
	public int getPriceCode() {
		return _priceCode;
	}
	public void setPriceCode(int priceCode) {
		_priceCode = priceCode;
	}
	
}
