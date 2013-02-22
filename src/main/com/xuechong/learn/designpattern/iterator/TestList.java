package com.xuechong.learn.designpattern.iterator;

import java.util.Iterator;

public class TestList implements Iterable<String>{

	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {
			private int total = 500;
			private int cursor=0;
			@Override
			public boolean hasNext() {
				return cursor<500;
			}
			@Override
			public String next() {
				return String.valueOf(++cursor);
			}
			@Override
			public void remove() {
				if(cursor==0){
					throw new NullPointerException();
				}
				cursor--;
				total--;
			}
		
		};
	}
	
	public static void main(String[] args) {
		TestList tl= new TestList();
		Iterator<String> i = tl.iterator();
		i.next();
		i.remove();
		for (String string : tl) {
			System.out.println(string);
		}
	}

}
