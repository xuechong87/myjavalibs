package com.xuechong.exl.process;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class QueryResultProcessor {
	
	/**
	 * 处理数据并导出EXL
	 * @param head
	 * @param conditions
	 * @param datas
	 * @param queryString
	 * @author xuechong
	 */
	@SuppressWarnings("unchecked")
	public static void Process(String head,List<String> conditions,List<Map> datas,String queryString){
		List<String> titles = encapeTitles(queryString,datas.get(0).keySet());
		exportData(head,conditions,titles,datas);
	}

	/**
	 * 对表头进行排序
	 * @param queryString
	 * @param titles
	 * @return
	 * @author xuechong
	 */
	private static List<String> encapeTitles(String queryString, Set<String> titles) {
		Map<Integer,String> temp = new TreeMap<Integer, String>();
		for (String title : titles) {
			temp.put(queryString.indexOf(title.toString()), title.toString());
		}
		if(temp.size()!= titles.size()){
			return new ArrayList<String>(titles);
		}
		return new ArrayList<String>(temp.values());
	}
	
	/**
	 * 导出数据
	 * @param titles
	 * @param conditions
	 * @param datas
	 * @author xuechong
	 */
	@SuppressWarnings("unchecked")
	private static void exportData(String head, List<String> titles,
			List<String> conditions, List<Map> datas) {
		//TODO
	}

}
