package com.xuechong.utils.msgcenter.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.xuechong.utils.msgcenter.MsgContext;
import com.xuechong.utils.msgcenter.dao.FSMsgConfigDao;
import com.xuechong.utils.msgcenter.model.FSMsgConfig;


public class FSMsgConfigBizImpl extends AbstractFSMsgConfigBiz{
	@Autowired
	private FSMsgConfigDao configDao;

	public FSMsgConfigBizImpl(){
		this.addObserver(MsgContext.getContext());
	}
	
	@Override
	protected void doRemove(String id) {
		this.configDao.removeById(id);
	}

	@Override
	protected void doModify(FSMsgConfig config) {
		this.configDao.modify(config);
	}

	@Override
	protected void doAdd(FSMsgConfig config) {
		this.configDao.add(config);
	}
	
	
	
}
