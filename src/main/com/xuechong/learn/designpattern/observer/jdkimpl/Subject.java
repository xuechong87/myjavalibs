package com.xuechong.learn.designpattern.observer.jdkimpl;

import java.util.Observable;

public class Subject extends Observable{
	
	private String name;
	public Subject(String name){
		this.name = name;
	}
	
	@Override
	public void notifyObservers(Object arg) {
		super.notifyObservers(arg);
	}
	
	public void doChange(){
		this.setChanged();
	}

	public String getName() {
		return name;
	}
	
}
