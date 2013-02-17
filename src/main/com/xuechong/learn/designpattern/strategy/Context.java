package com.xuechong.learn.designpattern.strategy;

/**
 * 使用者 (客户)
 * @author xuechong
 *
 */
public class Context {
	
	private Strategy strategy;
	
	public Context(Strategy strategy){
		super();
		this.strategy = strategy;
	}
	
	public void execute(){
		//do some common thing
		this.strategy.operation(new CallBack() {
			@Override
			public void someMethod() {
				// some diffrend method
			}
		});
		//do some common thing
	}
	
}
