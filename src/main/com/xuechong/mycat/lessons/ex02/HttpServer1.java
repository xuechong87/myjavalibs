package com.xuechong.mycat.lessons.ex02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import com.xuechong.mycat.constants.ServerConstants;

public class HttpServer1 {
private boolean shutdown = false;
	
	public static void main(String[] args) {
		HttpServer1 server = new HttpServer1();
		server.await();
	}
	public void await(){
		
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(ServerConstants.SERVE_PORT,1,InetAddress.getByName("127.0.0.1"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while(!shutdown){
			Socket socket = null;
			InputStream input = null;
			OutputStream output = null;
			
			
			try {
				socket = serverSocket.accept();
				input = socket.getInputStream();
				output = socket.getOutputStream();
				Request request = new Request(input);
				request.parse();
				Response response = new Response(output);
				response.setRequest(request);
				
				if(request.getUri().startsWith("/servlet/")){
					ServletProcessor1 processor = new ServletProcessor1();
					processor.process(request, response);
				}else{
					StaticResourceProcessor srp = new StaticResourceProcessor();
					srp.process(request, response);
					//静态资源
				}
				
				
				
				socket.close();
				shutdown = request.getUri().equals(ServerConstants.SHUT_DOWN_COMMAND);
			} catch (IOException e) {
				e.printStackTrace();
				continue;
			}
		}
	}
}
