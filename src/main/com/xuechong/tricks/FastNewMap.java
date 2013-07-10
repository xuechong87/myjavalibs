package com.xuechong.tricks;

import java.util.HashMap;
import java.util.Map;

public class FastNewMap {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>() {
			{
				put("a", "a");
				put("b", "b");
			}
		};
		
		for (String string : map.keySet()) {
			System.out.println(map.get(string));
		}
	}
}
