package com.xuechong.learn.designpattern.vistor.vistor;

import com.xuechong.learn.designpattern.vistor.model.Man;
import com.xuechong.learn.designpattern.vistor.model.Woman;

public class Success implements Visitor{  
	  
    public void visit(Man man) {  
        System.out.println("当男人成功时，背后多半有一个伟大的女人");  
    }  
  
    public void visit(Woman woman) {  
        System.out.println("当女人成功时，背后大多有一个不成功的男人");  
    }  
}  
