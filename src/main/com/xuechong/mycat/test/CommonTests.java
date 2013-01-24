package com.xuechong.mycat.test;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.xuechong.mycat.lessons.ex01.HttpServer;


public class CommonTests {
	public static void main(String[] args) {
		HttpServer server = new HttpServer();
		server.await();
		
	}
	
	class S1 implements Servlet{

		@Override
		public void destroy() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public ServletConfig getServletConfig() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getServletInfo() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void init(ServletConfig arg0) throws ServletException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void service(ServletRequest arg0, ServletResponse arg1)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			
		}
		
	}
}
