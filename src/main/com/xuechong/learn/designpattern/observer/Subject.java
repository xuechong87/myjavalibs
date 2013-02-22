package com.xuechong.learn.designpattern.observer;

import java.util.LinkedList;

public abstract class Subject {
	private LinkedList<Observer> observers = new LinkedList<Observer>();
	/**
	 * if change happens
	 */
	private boolean isChanged = false;
	
	/**
	 * add an Observer
	 * @param ob
	 * @author xuechong
	 */
	public void addObserver(Observer ob){
		this.observers.add(ob);
	}
	/**
	 * remove an Observer
	 * @param ob
	 * @author xuechong
	 */
	public void removeObserver(Observer ob){
		this.observers.remove(ob);
	}
	
	/**
	 * notify all Observers if change happens
	 * 
	 * @author xuechong
	 */
	public void notifyAllObservers(){
		this.notifyAllObservers(null);
	}
	/**
	 * notify all Observers if change happens
	 * @author xuechong
	 */
	public void notifyAllObservers(Object object){
		synchronized (this) {
			if(!this.isChanged){return;}//if nothing changed
			if(this.observers.isEmpty()){
				return;
			}
			for (Observer ob : this.observers) {
				ob.update(this, object);
			}
			this.clearChange();
		}
	}
	
	/**
	 * change the subject
	 * @author xuechong
	 */
	protected void change() {
		synchronized (this) {
			this.isChanged = true;
		}
	}
	
	protected boolean isChanged(){
		synchronized (this) {
			return this.isChanged;
		}
	}
	
	protected synchronized void clearChange(){
		this.isChanged =false;
	}
	
	public abstract void doSomeThing();
	
	
}
