package com.xuechong.learn.designpattern.vistor.model;

import com.xuechong.learn.designpattern.vistor.vistor.Visitor;

public class Man implements Person{

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
