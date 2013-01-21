package com.xuechong.exl.interfaces;

import java.util.List;
import java.util.Map;

import com.xuechong.dao.BaseDao;
import com.xuechong.exl.process.QueryResultProcessor;



public class ExlQueryUtil {
	
	private BaseDao dao;
	
	public ExlQueryUtil(BaseDao dao){
		super();
		this.dao = dao;
	}
	
	
	/**
	 * 按HQL查询并导出
	 * @param head
	 * @param conditions
	 * @param hql
	 * @param params
	 * @author xuechong
	 */
	@SuppressWarnings("unchecked")
	public void exportByHql(String head,List<String> conditions,String hql,List<Object> params){
		List<Map> result = this.dao.findMapList(hql, params);
		if(result.isEmpty()){
			//TODO
		}
		QueryResultProcessor.Process(head, conditions, result, hql);
	}
	
	public void exportByHql(String hql,List<Object> params){
		this.exportByHql(null, null, hql, params);
	}
	/**
	 * 按SQL查询并导出
	 * @param head
	 * @param conditions
	 * @param sql
	 * @param params
	 * @author xuechong
	 */
	@SuppressWarnings("unchecked")
	public void exportBySql(String head,List<String> conditions,String sql, List<Object> params){
		List<Map> result = this.dao.findMapListBySQL(sql, params);
		if(result.isEmpty()){
			//TODO
		}
		QueryResultProcessor.Process(head, conditions, result, sql);
	}
	public void exportBySql(String sql, List<Object> params){
		this.exportBySql(null, null, sql, params);
	}
}
