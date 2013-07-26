package com.xuechong.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class Hello {
	//13311
	//40891
	//59412
	//64045
	public static void main(String[] args) {
		for (int i = 40891; i < 59412; i++) {
			System.out.print((char)(i));
			System.out.println(i);
		}
		//\u33ff
		//\ufa2d
		
		System.out.println(Integer.toHexString(13311));
		System.out.println(Integer.toHexString(40891));
		System.out.println(Integer.toHexString(59412));
		System.out.println(Integer.toHexString(64045));
		System.out.println("\u4cfe");
		System.out.println("\u4E00");
		System.out.println("\u9FA5");
		System.out.println("\u9FA6");
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
