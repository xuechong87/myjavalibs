package com.xuechong.learn.designpattern.vistor.model;

import com.xuechong.learn.designpattern.vistor.vistor.Visitor;

public class Woman implements Person{

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
