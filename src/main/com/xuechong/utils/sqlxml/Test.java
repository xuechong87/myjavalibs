package com.xuechong.utils.sqlxml;

import com.xuechong.utils.sqlxml.context.SqlContext;


public class Test {
	public static void main(String[] args) {
		String sql = SqlContext.getByClass("bbb").getQueryById("list");
		System.out.println(sql);
	}
}
