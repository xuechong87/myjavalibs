package com.xuechong.learn.effectivejava.code.thread;

/**
 * 延迟初始化
 * @author xuechong
 */
public class LazyInit {
	/**
	 * The initialize-on-demand holder class<br>
	 * 只有一个类被调用时才会初始化,从而实现延迟加载
	 * @author xuechong
	 */
	private static class FooHolder{
		static final Foo foo = new Foo();
	}
	/**
	 * 这是正确的延迟加载
	 * @return
	 * @author xuechong
	 */
	public static Foo getFoo() {
		return FooHolder.foo;
	}
}


class LazyInitWrong{
	private static Foo foo = null;
	/**
	 * 这是 <b>错误</b> 的!!!!!!<br>
	 * 一般情况下,双重检查模式不能正确的工作<br>
	 * 但如果被共享的变量包含一个原语值,而不是一个对象引用,则他可以正确工作
	 * @return
	 * @author xuechong
	 */
	public static Foo getFoo(){
		if(foo==null){
			synchronized (Foo.class) {
				if(foo==null){
					foo=new Foo();
				}
			}
		}
		return foo;
	}
}

class Foo{
	
}

