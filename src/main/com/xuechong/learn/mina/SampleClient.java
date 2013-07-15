package com.xuechong.learn.mina;

import java.net.InetSocketAddress;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.mina.core.RuntimeIoException;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.example.netcat.NetCatProtocolHandler;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

public class SampleClient {

	public static void main(String[] args)  {
		try{
		NioSocketConnector connector = new NioSocketConnector();
		connector.setConnectTimeoutMillis(30*1000L);
		connector.getFilterChain().addLast(
				"codec",new ProtocolCodecFilter(new TextLineCodecFactory(
						Charset.forName("UTF-8"))));

		connector.getFilterChain().addLast("logger", new LoggingFilter());
		connector.setHandler(new NetCatProtocolHandler());
		
		IoSession session;
		
		 for (;;) {
		        try {
		        	URL url = new URL("http://yypt.shijia.org/schoolapp");
		            ConnectFuture future = connector.connect(
		            		new InetSocketAddress(url.getHost(), 80));
		            future.awaitUninterruptibly();
		            session = future.getSession();
		            break;
		        } catch (RuntimeIoException e) {
		            System.err.println("Failed to connect.");
		            e.printStackTrace();
		            Thread.sleep(5000);
		        }
		    }
		    // wait until the summation is done
		    session.getCloseFuture().awaitUninterruptibly();
		    connector.dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
