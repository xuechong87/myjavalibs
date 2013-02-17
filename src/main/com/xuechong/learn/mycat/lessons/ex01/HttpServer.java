package com.xuechong.learn.mycat.lessons.ex01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import com.xuechong.learn.mycat.constants.ServerConstants;

/**
 * 
 * @author Administrator
 *
 */
public class HttpServer {
	private boolean shutdown = false;
	
	
	public static void main(String[] args) {
		HttpServer server = new HttpServer();
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
				response.sendStaticResource();
				socket.close();
				shutdown = request.getUri().equals(ServerConstants.SHUT_DOWN_COMMAND);
			} catch (IOException e) {
				e.printStackTrace();
				continue;
			}
		}
	}
}
