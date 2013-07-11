package com.xuechong.utils.msgcenter.dao;

import com.xuechong.utils.msgcenter.model.FSMsgConfig;

public interface FSMsgConfigDao {
	public void add(FSMsgConfig config);
	public void removeById(String id);
	public void modify(FSMsgConfig config);
}
