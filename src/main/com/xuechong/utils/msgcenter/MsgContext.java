package com.xuechong.utils.msgcenter;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import com.xuechong.utils.msgcenter.biz.impl.AbstractFSMsgConfigBiz;

public class MsgContext implements Observer{
	protected Map<String,Boolean> webMsgContext = new HashMap<String, Boolean>();
	
	private static MsgContext context = new MsgContext();
	@Override
	public void update(Observable subject, Object args) {
		if(subject instanceof AbstractFSMsgConfigBiz){
			this.reloadContext();
		}
	}
	
	private void reloadContext() {
		
	}

	public static MsgContext getContext(){
		return context;
	}
	
	private MsgContext(){super();}
}
