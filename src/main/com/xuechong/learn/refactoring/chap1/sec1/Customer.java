package com.xuechong.learn.refactoring.chap1.sec1;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	private String name;
	private Vector<Rental> rentals = new Vector<Rental>();
	public Customer(String name) {
		super();
		this.name = name;
	}
	
	public void addRental(Rental rental){
		this.rentals.add(rental);
	}
	
	public String statement(){
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration retals = this.rentals.elements();
		String result = "Retanl Record for" + getName() + "\n";
			
		return result;
	}

	public String getName() {
		return name;
	}
}
