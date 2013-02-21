package com.xuechong.utils.sqlxml.context;

import java.util.Map;

public class SqlContext {
	
	private static Map<String,ClassSqlContext> sqlContext = null;
	
	private static class ContextHolder{
		private static void init() {
			
			
			
		}
		private static final Map<String,ClassSqlContext> getSqlContext(){
			if(sqlContext==null){
				init();
			}
			return sqlContext;
		}
	}
	/**
	 * get the classSqlContext by class name
	 * @param key
	 * @return
	 * @author xuechong
	 */
	public static ClassSqlContext getByClass(String key){
		return ContextHolder.getSqlContext().get(key);
	}
	
}
