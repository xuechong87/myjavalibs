package com.xuechong.dao;

import java.util.List;
import java.util.Map;

public interface BaseDao {

	List<Map> findMapList(String hql, List<Object> params);

	List<Map> findMapListBySQL(String sql, List<Object> params);

}
