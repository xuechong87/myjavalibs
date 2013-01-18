package com.xuechong.exl.processor;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.xuechong.exl.annotations.ExlModel;


public class AnnotationResultProcessor {
	
	@SuppressWarnings("unchecked")
	public void process(String head,List<String> conditions,Collection dataCollection){
		if(dataCollection.isEmpty()){
			
		}else{
			Class c = dataCollection.iterator().next().getClass();
			if(c.getAnnotation(ExlModel.class)==null){
				throw new IllegalArgumentException("不支持的导出类型");
			}
		}
	}
	
	public static void main(String[] args) {
		Collection<String> s = new ArrayList<String>();
		String ss = ((ParameterizedType) s.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0].toString();
		System.out.println(ss);
	}
	
}
