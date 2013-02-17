package com.xuechong.learn.designpattern.strategy;

public abstract class Strategy {
	public void operation(CallBack callBack){
		//do some common thing
		callBack.someMethod();
		//do some commong thing
	}
}
