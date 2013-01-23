package com.xuechong.exl.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.xuechong.exl.ExlAnnotationUtil;
import com.xuechong.model.PersonModel;

public class AnnoInterfaceTests {
	@Test
	public void test() {
		List<String> conditions = new ArrayList<String>();

		conditions.add("condition1=123123");
		conditions.add("condition2=1256989009823");
		conditions.add("condition3=11245363");

		List<PersonModel> dataList = new ArrayList<PersonModel>();
		PersonModel p1 = new PersonModel("p1", 1);
		dataList.add(p1);
		PersonModel p2 = new PersonModel("p2", 2);
		dataList.add(p2);
		PersonModel p3 = new PersonModel("p3", 3);
		dataList.add(p3);
		//ExlAnnotationUtil.export(dataList);
		//ExlAnnotationUtil.export(dataList, 3);
		//ExlAnnotationUtil.export(dataList, 2);
		ExlAnnotationUtil.export("asdasdasd",conditions,dataList, 1);
	}

}
