package com.xuechong.learn.designpattern.observer;

public class Test {
	public static void main(String[] args) {
		Subject sub = new Subject() {
			@Override
			public void doSomeThing(){
				System.out.println("doSome change");
				this.change();
			}
		};
		sub.addObserver(new Observer() {
			@Override
			public void update(Subject subject, Object object) {
				System.out.println("ob1 reveived");
			}
		});
		sub.addObserver(new Observer() {
			@Override
			public void update(Subject subject, Object object) {
				System.out.println("ob2 reveived");
			}
		});
		sub.doSomeThing();
		sub.notifyAllObservers();
		sub.notifyAllObservers();
	}
}
