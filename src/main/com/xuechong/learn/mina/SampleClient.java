package com.xuechong.learn.mina;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.RuntimeIoException;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.example.sumup.ClientSessionHandler;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

public class SampleClient {

	public static void main(String[] args) throws InterruptedException {
		NioSocketConnector connector = new NioSocketConnector();
		connector.getFilterChain().addLast(
				"codec",new ProtocolCodecFilter(new TextLineCodecFactory(
						Charset.forName("UTF-8"))));

		connector.getFilterChain().addLast("logger", new LoggingFilter());
		connector.setHandler(new ClientSessionHandler(new int[]{0,1,2}));
		
		IoSession session;
		
		 for (;;) {
		        try {
		            ConnectFuture future = connector.connect(
		            		new InetSocketAddress("http://z.cn", 80));
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
	}
}
