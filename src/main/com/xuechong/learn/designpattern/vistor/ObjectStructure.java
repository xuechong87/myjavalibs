package com.xuechong.learn.designpattern.vistor;

import java.util.ArrayList;
import java.util.List;

import com.xuechong.learn.designpattern.vistor.model.Person;
import com.xuechong.learn.designpattern.vistor.vistor.Visitor;

public class ObjectStructure {   
    private List<Person> elements = new ArrayList<Person>();   
  
    public void attach(Person person){   
        elements.add(person);   
    }   
       
    public void detach(Person person){   
        elements.remove(person);   
    }   
       
    //遍历各种具体元素并执行他们的accept方法   
    public void display(Visitor visitor){   
        for(Person p:elements){   
            p.accept(visitor);   
        }   
    }   
}  
