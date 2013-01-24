package com.xuechong.effectivejava.method;

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
	
	public static void main(String[] args) {
		try {
			new MethodTests().run();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
