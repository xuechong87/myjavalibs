package com.xuechong.learn.mycat.lessons.ex02;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import com.xuechong.learn.mycat.constants.ServerConstants;

/**
 * 用于处理SERVLET的HTTP请求
 * @author Administrator
 *
 */
public class ServletProcessor1 {
	
	public void process(Request request,Response response){
		String uri = request.getUri();
		//////////
		////请求为  /servlet/XXServlet.xxx
		String serlvetName = uri.substring(uri.lastIndexOf("/")+1);
		URLClassLoader loader = null;
		
		
		try {
			URL urls[] = new URL[1];
			URLStreamHandler streamHandler = null;
			File classpath = new File(ServerConstants.WEB_ROOT);
			String respository = (new URL("file",null,classpath.getCanonicalPath()+File.separator)).toString();
			urls[0] = new URL(null,respository,streamHandler);
			loader = new URLClassLoader(urls);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Class servletClass = null;
		try {
			servletClass = loader.loadClass(serlvetName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Servlet servlet = (Servlet) servletClass.newInstance();
			servlet.service(request, response);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
