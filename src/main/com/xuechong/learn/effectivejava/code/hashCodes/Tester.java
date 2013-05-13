package com.xuechong.learn.effectivejava.code.hashCodes;


import org.junit.Test;

import com.xuechong.learn.effectivejava.code.model.Personmodel;


public class Tester {
	@Test
	public void printHash(){
		Personmodel p1 = new Personmodel();
		p1.setAge(20);
		p1.setName("p1");
		Personmodel p2 = new Personmodel();
		p2.setAge(21);
		p2.setName("p2");
		Personmodel p3 = new Personmodel();
		p3.setAge(20);
		p3.setName("p1");
		System.out.println("p1 eq p2:" + p1.equals(p2) + "| p1 hash:" + p1.hashCode() + "| p2 hash:" + p2.hashCode());
		System.out.println("p1 eq p3:" + p1.equals(p3) + "| p1 hash:" + p1.hashCode() + "| p3 hash:" + p3.hashCode());
		System.out.println("p3 eq p1:" + p3.equals(p1) + "| p1 hash:" + p1.hashCode() + "| p3 hash:" + p3.hashCode());
		System.out.println("p1 eq p1:" + p1.equals(p1) + "| p1 hash:" + p1.hashCode() );
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
	}
	
	public static void main(String[] args) {
		Integer i = 100;
		System.out.println(i.toHexString(i));
	}
	
}
