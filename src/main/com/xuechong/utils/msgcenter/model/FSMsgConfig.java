package com.xuechong.utils.msgcenter.model;

/**
 * the function support message config model
 * @author xuechong
 * created 2013-7-11
 */
public class FSMsgConfig {
	private String id;
	private String name;
	private boolean webMsg;
	private boolean mobileMsg;
	private boolean oaMsg;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getWebMsg() {
		return webMsg;
	}
	public void setWebMsg(boolean webMsg) {
		this.webMsg = webMsg;
	}
	public boolean getMobileMsg() {
		return mobileMsg;
	}
	public void setMobileMsg(boolean mobileMsg) {
		this.mobileMsg = mobileMsg;
	}
	public boolean getOaMsg() {
		return oaMsg;
	}
	public void setOaMsg(boolean oaMsg) {
		this.oaMsg = oaMsg;
	}
	
}
