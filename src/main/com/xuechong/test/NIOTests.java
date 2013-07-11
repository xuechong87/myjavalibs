package com.xuechong.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

import org.junit.Test;

public class NIOTests {

	@Test
	public void socketChannel() throws IOException{
		URL url = new URL("https://a248.e.akamai.net/assets.github.com/assets/github-6db070a7fd82c30d0b0bf14595d2913f6fa7886c.js");
		String file = url.getFile( );

		SocketAddress remote = new InetSocketAddress(url.getHost(), 80);
		SocketChannel socket = SocketChannel.open(remote);
		socket.configureBlocking(false);
		
		FileOutputStream out = new FileOutputStream("F:/socketTests.txt");
	    FileChannel localFile = out.getChannel( );
	    String request = "GET " + file + " HTTP/1.1\r\n"
	     + "User-Agent: HTTPGrab\r\n"
	     + "Accept: text/*\r\n"
	     + "Connection: close\r\n"
	     + "Host: " + url.getHost() + "\r\n"
	     + "\r\n";
	    ByteBuffer header = ByteBuffer.wrap(request.getBytes("US-ASCII"));
	    socket.write(header);
	    ByteBuffer buffer = ByteBuffer.allocate(8192);
	    while (socket.read(buffer) != -1) {
	      buffer.flip( );
	      localFile.write(buffer);
	      buffer.clear( );
	    }
	    localFile.close( );
	    socket.close( );

	}
}
