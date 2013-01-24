package com.xuechong.mycat.lessons.ex01;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.xuechong.mycat.constants.ServerConstants;

public class Response {
	private static final int BUFFER_SIZE = 1024;
	Request request;
	OutputStream output;
	
	public Response(OutputStream output){
		this.output = output;
	}
	
	public void setRequest (Request request){
		this.request = request;
	}
	/**
	 * 发送一个静态资源 <br>
	 * 假如请求的文件不存在 则发送一个错误信息到浏览器
	 * @throws IOException
	 */
	public void sendStaticResource() throws IOException{
		byte[] bytes = new byte[BUFFER_SIZE];
		FileInputStream fis = null;
		String errorMessage = "HTTP/1.1 404 File not found \r\n " +
		"Content-Type: text/xml\r\n" +
		"Content-Length: 23\r\n" +
		"\r\n" +
		"<h1>FILE NOT FOUND</h1>";
		try {
			File file = new File(ServerConstants.WEB_ROOT,request.getUri());
			if(file.exists()){
				fis = new FileInputStream(file);
				int ch = fis.read(bytes,0,BUFFER_SIZE);
				while(ch!=-1){
					output.write(bytes,0,ch);
					ch = fis.read(bytes,0,BUFFER_SIZE);
				}
			}else{
				
				output.write(errorMessage.getBytes());
			}
		} catch (Exception e) {
			e.printStackTrace();
			output.write(errorMessage.getBytes());
		}finally{
			if(fis!=null){fis.close();}
		}
	}
}
