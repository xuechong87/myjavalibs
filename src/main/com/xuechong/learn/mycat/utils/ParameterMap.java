package com.xuechong.learn.mycat.utils;

import java.util.HashMap;
import java.util.Map;

public class ParameterMap extends HashMap {

	public ParameterMap(){
		super();
	}
	
	public ParameterMap(int initialCapacity){
		super(initialCapacity);
	}
	
	public ParameterMap(int arg0,float arg1){
		super(arg0, arg1);
	}
	
	public ParameterMap (Map m){
		super(m);
	}
	
	private boolean locked = true;
	
	
}
