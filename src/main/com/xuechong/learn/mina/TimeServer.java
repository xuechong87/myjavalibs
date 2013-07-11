package com.xuechong.learn.mina;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.example.gettingstarted.timeserver.TimeServerHandler;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class TimeServer {
	private static final int PORT = 8888;
	public static void main(String[] args) {
		
		try {
	        IoAcceptor acceptor = new NioSocketAcceptor();

	        acceptor.getFilterChain().addLast( "logger", new LoggingFilter() );
	        acceptor.getFilterChain().
	        	addLast( "codec", new ProtocolCodecFilter( 
	        				new TextLineCodecFactory( Charset.forName( "UTF-8" ))));
	        acceptor.setHandler(  new TimeServerHandler() );
			
	        acceptor.getSessionConfig().setReadBufferSize( 2048 );
	        acceptor.getSessionConfig().setIdleTime( IdleStatus.BOTH_IDLE, 10 );
	        
	        acceptor.bind( new InetSocketAddress(PORT) );
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
