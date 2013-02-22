package com.xuechong.learn.designpattern.iterator;

import java.util.Iterator;
import java.util.LinkedList;

public class CollectionIterator <T> implements Iterator<T>{
	
	private LinkedList<T> list ;
	private Integer curIndex = -1;
	CollectionIterator(LinkedList<T> list){
		this.list = list;
	}
	
	@Override
	public boolean hasNext() {
		return list.size() > curIndex +1;
	}
	@Override
	public T next() {
		return list.get(++curIndex);
	}
	@Override
	public void remove() {
		if(curIndex<0){
			throw new NullPointerException();
		}
		list.remove(curIndex);
		curIndex--;
	}


}
