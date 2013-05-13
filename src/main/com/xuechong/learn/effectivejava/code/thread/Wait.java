package com.xuechong.learn.effectivejava.code.thread;

/**
 * 永远不要在循环外调用wait
 * @author xuechong
 *
 */
public class Wait {
	static volatile boolean  go_on = false;
	/**
	 * 使用wait方法的标准模式
	 * @author xuechong
	 * @throws InterruptedException 
	 */
	public void someMethod() throws InterruptedException{
		Object obj = new Object();
		boolean condition_doesnot_hold = true;
		while(condition_doesnot_hold){
			obj.wait();
			//Perform action appropriate to condition
		}
		//总是用wait循环模式来调用wait方法.!!!!!永远!!!!永远不要在循环的外面调用wait.循环被用于等待前后测试条件
	}
	
	public static void main(String[] args) {
		Thread tl = new Thread(new ThreadLong());
		Thread ts = new Thread(new ThreadShort());
		tl.start();
		ts.start();
	}
	
	static class ThreadLong implements Runnable{
		@Override
		public void run() {
			synchronized (ThreadLong.class) {
				for (int i = 0; i < 10; i++) {
					System.out.println("long>"+i);
					try {
						ThreadLong.class.wait(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				go_on = true;
				ThreadLong.class.notifyAll();
			}
		}
	}
	
	static class ThreadShort implements Runnable{
		@Override
		public void run() {
			synchronized (ThreadShort.class) {
				System.out.println("short start");
				int i = 0;
				while (!go_on) {
					try {
						ThreadShort.class.wait(6000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("short>" + i++ );
				}
				System.out.println("short finish");
			}
		}
	}
	
	static class ThreadNotify implements Runnable{
		@Override
		public void run() {
			
		}
	}
}
