package com.xuechong.learn.mycat.lessons.ex01;

import java.io.IOException;
import java.io.InputStream;


/**
 * 从负责与客户端通信的SOCKET中传递过来InputStream对象来构造这个类的一个实例.<br/>
 * 调用InputStream对象其中一个read方法来获取Http请求的原始数据
 * @author xuechong
 *
 */
public class Request {
	
	private InputStream input ;
	private String uri;
	
	public Request (InputStream input){
		this.input = input;
	}
	
	public void parse(){
		StringBuffer request = new StringBuffer(2048);
		int i ;
		byte[] buffer = new byte[2048];
		
		try {
			i = input.read(buffer);
		} catch (IOException e) {	
			e.printStackTrace();
			i=-1;
		}
		
		for (int j = 0; j < i; j++) {
			request.append((char)buffer[j]);
		}
		System.out.println(request.toString());
		this.uri = this.parseUri(request.toString());
	}
	
	
	/**
	 * 从请求行里获得URI<br/>
	 * HTTP请求的格式为<br/>
	 * <b>GET /index.html HTTP/1.1</b>
	 * @param requestString
	 * @return
	 */
	private String parseUri(String requestString){
		int index1,index2;
		index1 = requestString.indexOf(' ');
		if(index1!=-1){
			index2 = requestString.indexOf(' ',index1 + 1);
			if (index2>index1) {
				return requestString.substring(index1+1,index2);
			}
		}
		return null;
	}
	
	public String getUri(){
		return this.uri;
	}
	
}
