package com.xuechong.learn.effectivejava.code.method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodTests {
	
	private Action act = new Action() {
		@Override
		public void dosome() {
			System.out.println("dosome");
		}
	};
	
	private void run() throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Method m = act.getClass().getMethod("dosome");
		this.invoke(m);
	}
	
	private void invoke(Method m ) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		m.invoke(act, null);
	}
	
	public static void main(String[] args) throws Exception{
			new MethodTests().run();
	}
}
