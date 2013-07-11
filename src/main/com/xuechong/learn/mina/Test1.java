package com.xuechong.learn.mina;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URL;

import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

public class Test1 {
	public static void main(String[] args) {
		
		try {
			IoConnector connector = new NioSocketConnector();
			URL url = new URL("http://z.cn");
			SocketAddress remote = new InetSocketAddress(url.getHost(),80);
			
			connector.setHandler(new IoHandler() {
				@Override
				public void sessionOpened(IoSession session) throws Exception {
					System.out.println("sessionOpened");
				}
				
				@Override
				public void sessionIdle(IoSession session, IdleStatus status)
						throws Exception {
					System.out.println("sessionIdle");
				}
				
				@Override
				public void sessionCreated(IoSession session) throws Exception {
					System.out.println("sessionCreated");
				}
				
				@Override
				public void sessionClosed(IoSession session) throws Exception {
					System.out.println("sessionClosed");
				}
				
				@Override
				public void messageSent(IoSession session, Object message) throws Exception {
					System.out.println("messageSent");
				}
				
				@Override
				public void messageReceived(IoSession session, Object message)
						throws Exception {
					System.out.println("messageReceived");
					System.out.println(message.toString());
				}
				
				@Override
				public void exceptionCaught(IoSession session, Throwable cause)
						throws Exception {
					System.out.println("exceptionCaught");
				}
			});
			IoSession session = connector.connect(remote).awaitUninterruptibly().getSession();
			session.write("aa");
			String s = session.read().getMessage().toString();
			System.out.println(s);
			session.getCloseFuture().awaitUninterruptibly();
			connector.dispose();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
