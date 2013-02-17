package com.xuechong.learn.mycat.lessons.ex03.connector.http;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import com.xuechong.learn.mycat.constants.ServerConstants;

public class HttpConnector implements Runnable {

	boolean stopped;
	private String scheme = "http";
	
	public String getScheme() {
		return scheme;
	}

	@Override
	public void run() {
		ServerSocket serverSocket = null;
		int port = ServerConstants.SERVE_PORT;
		
		try {
			serverSocket = new ServerSocket(port, 1,InetAddress.getByName("127.0.0.1"));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while(!stopped){ 
			Socket socket = null;
			try {
				socket = serverSocket.accept();
			} catch (IOException e) {
				e.printStackTrace();
				continue;
			}
			
		}
	}
	public void start(){
		Thread thread = new Thread(this);
		thread.start();
	}

}
