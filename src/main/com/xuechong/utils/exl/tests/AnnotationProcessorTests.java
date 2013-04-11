package com.xuechong.utils.exl.tests;

import java.util.ArrayList;
import java.util.List;

import com.xuechong.model.PersonModel;
import com.xuechong.utils.exl.mapping.SheetContent;
import com.xuechong.utils.exl.process.AnnotationResultProcessor;

public class AnnotationProcessorTests {
	
	@org.junit.Test
	public void test1(){
		
		List<String> conditions = new ArrayList<String>();
		
		conditions.add("condition1=123123");
		conditions.add("condition2=1256989009823");
		conditions.add("condition3=11245363");
		
		List<PersonModel> pList = new ArrayList<PersonModel>();
		PersonModel p1 = new PersonModel("p1",1);
		pList.add(p1);
		PersonModel p2 = new PersonModel("p2",2);
		pList.add(p2);
		PersonModel p3 = new PersonModel("p3",3);
		pList.add(p3);
		
		AnnotationResultProcessor.process("this is the head", conditions, pList, 1);
	}
	@org.junit.Test
	public void sheetTest(){
		
		List<String> conditions = new ArrayList<String>();
		
		conditions.add("condition1=123123");
		conditions.add("condition2=1256989009823");
		conditions.add("condition3=11245363");
		
		List<PersonModel> pList = new ArrayList<PersonModel>();
		PersonModel p1 = new PersonModel("p1wqeqeqweq",1);
		pList.add(p1);
		PersonModel p2 = new PersonModel("p2ffffa",2);
		pList.add(p2);
		PersonModel p3 = new PersonModel("p312344",3);
		pList.add(p3);
		SheetContent content1 = new SheetContent("head1", conditions, pList,null);
		SheetContent content2 = new SheetContent("head2", conditions, pList,1);

		AnnotationResultProcessor.
			process("sheetxls", new SheetContent[]{content1,content2});
	}
	
}
