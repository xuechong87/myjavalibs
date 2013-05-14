package com.xuechong.learn.refactoring.code.chap1.sec3;

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
		Enumeration<Rental> retals = this.rentals.elements();
		String result = "Retanl Record for" + getName() + "\n";
		while(retals.hasMoreElements()){
			Rental each = retals.nextElement();
			
			frequentRenterPoints++;
			if(each.getMovie().getPriceCode()==Movie.NEW_RELEASE
					&&each.getDaysRented()>1){
				frequentRenterPoints++;
			}
			result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
			totalAmount += each.getCharge();
		}
			
		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints + "frequent renter points";
		return result;
	}


	public String getName() {
		return name;
	}
}
