package com.xuechong.learn.designpattern.vistor.model;

import com.xuechong.learn.designpattern.vistor.vistor.Visitor;

public interface Person {   
    void accept(Visitor visitor);   
}  
