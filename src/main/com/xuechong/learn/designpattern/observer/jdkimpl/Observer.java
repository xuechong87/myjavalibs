package com.xuechong.learn.designpattern.observer.jdkimpl;

import java.util.Observable;

public class Observer implements java.util.Observer{

	private String name;
	public Observer (String name){
		this.name = name;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Subject){
			System.out.println("observer "+this.name  + "|receive subject->" + ((Subject)o).getName());
		}
	}

}
