package com.xuechong.learn.designpattern.vistor.vistor;

import com.xuechong.learn.designpattern.vistor.model.Man;
import com.xuechong.learn.designpattern.vistor.model.Woman;

public interface Visitor {   
    public void visit(Man man);   
    public void visit(Woman woman);   
}
