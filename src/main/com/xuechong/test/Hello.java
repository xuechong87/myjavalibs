package com.xuechong.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Hello {
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE+1 == Integer.MIN_VALUE);
//		int count =0;
//		for (int i = 0x7fffffff-100; i <= 0x7fffffff; i++) {
//			count ++;
//			System.out.println(count);
//		}
//		System.out.println("fin");
	}	
	
	public static void method1(){
		byte bytes[] = new byte[256];    
        for(int i = 0; i < 256; i++)
            bytes[i] = (byte)i;
        String str = new String(bytes);
        for(int i = 0, n = str.length(); i < n; i++)
            System.out.print((int)str.charAt(i) + " ");
	}
}
