package com.xuechong.learn.mycat.lessons.ex02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.xuechong.learn.mycat.constants.ServerConstants;

public class Response implements HttpServletResponse {

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
	
	@Override
	public PrintWriter getWriter() throws IOException {
		return new PrintWriter(this.output);
	}
	
	
	////////////////////////////////////////////////////
	/////////
	//////////////////////////
	@Override
	public void addCookie(Cookie arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addDateHeader(String arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addHeader(String arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addIntHeader(String arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean containsHeader(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String encodeRedirectURL(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String encodeRedirectUrl(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String encodeURL(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String encodeUrl(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendError(int arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendError(int arg0, String arg1) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendRedirect(String arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDateHeader(String arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHeader(String arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIntHeader(String arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStatus(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStatus(int arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void flushBuffer() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getBufferSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCharacterEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public boolean isCommitted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetBuffer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBufferSize(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCharacterEncoding(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setContentLength(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setContentType(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLocale(Locale arg0) {
		// TODO Auto-generated method stub
		
	}

}
