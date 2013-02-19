package com.xuechong.learn.effectivejava.thread;

public class StoppableThread extends Thread{
	
	private boolean  stopRequested = false;
	@Override
	public void run() {
		boolean done = false;
		while(!this.stopRequested&&!done){
			//do something
		}
	}
	
	/**
	 * request  stop the thread
	 * @author xuechong
	 */
	public synchronized void requestStop(){
		this.stopRequested = true;
	}
	
	/**
	 * 
	 * @return
	 * @author xuechong
	 */
	public synchronized boolean getStopRequested(){
		return this.stopRequested;
	}
	
	
}

class StoppableThread2 extends Thread{
	
	/**
	 * Volatile修饰的成员变量在每次被线程访问时，都强迫从共享内存中重读该成员变量的值。而且，当成员变量发生变化时，强迫线程将变化值回写到共享内存。这样在任何时刻，两个不同的线程总是看到某个成员变量的同一个值。

		Java语言规范中指出：为了获得最佳速度，允许线程保存共享成员变量的私有拷贝，而且只当线程进入或者离开同步代码块时才与共享成员变量的原始值对比。
		
		这样当多个线程同时与某个对象交互时，就必须要注意到要让线程及时的得到共享成员变量的变化。
		
		而volatile关键字就是提示VM：对于这个成员变量不能保存它的私有拷贝，而应直接与共享成员变量交互。
		
		使用建议：在两个或者更多的线程访问的成员变量上使用volatile。当要访问的变量已在synchronized代码块中，或者为常量时，不必使用。
		
		由于使用volatile屏蔽掉了VM中必要的代码优化，所以在效率上比较低，因此一定在必要时才使用此关键字。 
		
		
		就跟C中的一样 禁止编译器进行优化~~~~
	 */
	private volatile boolean  stopRequested = false;
	
	@Override
	public void run() {
		boolean done = false;
		while(!this.stopRequested&&!done){
			//do something
		}
	}
	public void requestStop(){
		this.stopRequested = true;
	}
	public boolean getStopRequested(){
		return this.stopRequested;
	}
	
}
