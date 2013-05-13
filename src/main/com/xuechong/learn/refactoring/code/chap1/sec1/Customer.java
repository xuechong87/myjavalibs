package com.xuechong.learn.refactoring.code.chap1.sec1;

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
			double thisAmount = 0;
			Rental each = retals.nextElement();
			
			switch (each.getMovie().getPriceCode()) {
			case Movie.REGULAR:
				thisAmount+=2;
				if(each.getDaysRented()>2){
					thisAmount+=(each.getDaysRented()-2)*1.5;
				}
				break;
			case Movie.NEW_RELEASE:
				thisAmount += each.getDaysRented()*3;
				break;
			case Movie.CHILDREN:
				thisAmount += 1.5;
				if(each.getDaysRented()>3){
					thisAmount+=(each.getDaysRented()-3)*1.5;
				}
				break;
			}
			frequentRenterPoints++;
			if(each.getMovie().getPriceCode()==Movie.NEW_RELEASE
					&&each.getDaysRented()>1){
				frequentRenterPoints++;
			}
			result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
			totalAmount += thisAmount;
		}
			
		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints + "frequent renter points";
		return result;
	}

	public String getName() {
		return name;
	}
}
