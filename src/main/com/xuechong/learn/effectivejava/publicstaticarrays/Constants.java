package com.xuechong.learn.effectivejava.publicstaticarrays;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class Constants {
	//这是错误的!!!!!!
	public static final String[] STRINGS = {"1","2","3"};
	
	///这是正确的!!! 
	private static final String[] STRS = {"1","2","3"};
	public static final List<String> STR_VALUES = 
		Collections.unmodifiableList(Arrays.asList(STRS));
	public static String[] getSTR (){
		return STRS.clone();
	}
	
	@Test
	public void test(){
		System.out.print("STRINGS ORIGIN:");
		write(STRINGS);
		STRINGS[0] = "4";
		STRINGS[1] = "5";
		STRINGS[2] = "6";
		System.out.print("STRINGS CHANGED:");
		write(STRINGS);
		System.out.print("STR_VALUES ORIGIN:");
		write(STR_VALUES);
		try {
			STR_VALUES.add(0, "9");
			STR_VALUES.add("4");
			STR_VALUES.add("5");
			STR_VALUES.add("6");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.print("STR_VALUES CHANGED:");
		write(STR_VALUES);
		
	}
	
	@SuppressWarnings("unchecked")
	public void write(Object list){
		if(list instanceof String[]){
			for (String s : (String[])list) {
				System.out.print(s);
				System.out.print("|");
			}
			System.out.println();
		}
		if(list instanceof Collection){
			for (String s : (Collection<String>)list) {
				System.out.print(s);
				System.out.print("|");
			}
			System.out.println();
		}
	}
}
