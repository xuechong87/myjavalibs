package com.xuechong.model;

import com.xuechong.exl.annotations.ExlData;
import com.xuechong.exl.annotations.ExlModel;

@ExlModel(viewTypes={0,1})
public class PersonModel {
	@ExlData(sortId=1,title={"姓名","姓名"})
	private String name;
	@ExlData(sortId=2,title={"年龄","age"})
	private Integer age;
	public PersonModel() {
		super();
	}
	public PersonModel(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
}
