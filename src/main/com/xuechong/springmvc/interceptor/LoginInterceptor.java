//package com.xuechong.springmvc.interceptor;
//
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.log4j.Logger;
//
//public class LoginInterceptor implements HandlerInterceptor {
//
//	private static final Logger logger = Logger.getLogger(LoginInterceptor.class);
//	
//	public void afterCompletion(HttpServletRequest reqeust,
//			HttpServletResponse response, Object object, Exception exception)
//			throws Exception {
//		System.out.println("Interceptor executed");
//	}
//
//	public void postHandle(HttpServletRequest reqeust, HttpServletResponse response,
//			Object object, ModelAndView modelAndView) throws Exception {
//
//	}
//
//	public boolean preHandle(HttpServletRequest reqeust, HttpServletResponse response,
//			Object object) throws Exception {
//		
//		return true;
//	}
//
//}
