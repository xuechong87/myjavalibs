package com.xuechong.learn.designpattern.observer.jdkimpl;

public class Test {
	public static void main(String[] args) {
		Subject subject = new Subject("suba");
		subject.addObserver(new Observer("aaa"));
		subject.addObserver(new Observer("bbb"));
		subject.doChange();
		subject.notifyObservers();
		subject.notifyObservers();
	}
}
