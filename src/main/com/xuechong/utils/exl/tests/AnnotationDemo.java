package com.xuechong.utils.exl.tests;

import java.lang.reflect.Field;

import com.xuechong.utils.exl.annotations.ExlData;
import com.xuechong.utils.exl.annotations.ExlModel;


@ExlModel
public class AnnotationDemo {
	@ExlData(sortId=1,title={"姓名"})
	private String name;
	@ExlData(sortId=2,title={"ID"})
	private String id;
	
	public static void main(String[] args) {
		Field fs[] =AnnotationDemo.class.getDeclaredFields();
		for (Field field : fs) {
			if(field.getAnnotation(ExlData.class)!=null){
				ExlData data =  field.getAnnotation(ExlData.class);
				System.out.println(data.sortId() + data.title()[0]);
			}
		}
		
	}
}

