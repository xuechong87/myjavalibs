package com.xuechong.utils.msgcenter.biz.impl;

import java.util.Observable;

import com.xuechong.utils.msgcenter.biz.FSMsgConfigBiz;
import com.xuechong.utils.msgcenter.model.FSMsgConfig;

public abstract class AbstractFSMsgConfigBiz extends Observable implements FSMsgConfigBiz{
	
	public void add(FSMsgConfig config) {
		this.doAdd(config);
		setChanged();
		this.notifyObservers();
	};
	@Override
	public void modify(FSMsgConfig config) {
		this.modify(config);
		setChanged();
		this.notifyObservers();
	}
	@Override
	public void removeById(String id) {
		this.doRemove(id);
		setChanged();
		this.notifyObservers();
	}
	
	protected abstract void doRemove(String id);
	protected abstract void doModify(FSMsgConfig config);
	protected abstract void doAdd(FSMsgConfig config);
}
