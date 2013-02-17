package com.xuechong.learn.mycat.lessons.ex02;

import java.io.IOException;

/**
 * 提供静态资源请求
 * @author Administrator
 */
public class StaticResourceProcessor {
	
	public void process(Request request,Response response){
		try {
			response.sendStaticResource();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
