package com.xuechong.mycat.constants;

import java.io.File;

public class ServerConstants {
	/**
	 * WEBROOT目录地址 
	 */
	public static final String WEB_ROOT =System.getProperty("user.dir")+File.separator+"WEBROOT";
	/**
	 * 关闭服务指令字符
	 */
	public static final String SHUT_DOWN_COMMAND = "/SHUT_DOWN_SERVER";
	
	/**
	 * 监听端口号
	 */
	public static final int SERVE_PORT = 0x1f90;
}
