package com.xuechong.dao;

import java.util.List;
import java.util.Map;

public interface BaseDao {

	@SuppressWarnings("unchecked")
	List<Map> findMapList(String hql, List<Object> params);

	@SuppressWarnings("unchecked")
	List<Map> findMapListBySQL(String sql, List<Object> params);

}
