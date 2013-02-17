package com.xuechong.learn.designpattern.vistor;

import com.xuechong.learn.designpattern.vistor.model.Man;
import com.xuechong.learn.designpattern.vistor.model.Woman;
import com.xuechong.learn.designpattern.vistor.vistor.Love;

public class Test {
	public static void main(String[] args) {
		ObjectStructure os = new ObjectStructure();
		os.attach(new Man());
		os.attach(new Woman());
		os.display(new Love());
	}
}
