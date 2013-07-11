package com.xuechong.utils.msgcenter.biz;

import com.xuechong.utils.msgcenter.model.FSMsgConfig;

public interface FSMsgConfigBiz {
	void add(FSMsgConfig config);
	void modify(FSMsgConfig config);
	void removeById(String id);
}
