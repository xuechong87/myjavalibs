package com.xuechong.learn.designpattern.vistor.vistor;

import com.xuechong.learn.designpattern.vistor.model.Man;
import com.xuechong.learn.designpattern.vistor.model.Woman;

public class Love implements Visitor{  
	  
    public void visit(Man man) {  
        System.out.println("当男人恋爱时，凡事不懂也装懂");  
    }  
  
    public void visit(Woman woman) {  
        System.out.println("当女人恋爱时，遇事懂也装不懂");  
    }  
}  
