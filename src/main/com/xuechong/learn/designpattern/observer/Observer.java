package com.xuechong.learn.designpattern.observer;

public interface Observer {
	/**
	 * when the subject has been changed ,execute this
	 * @param subject
	 * @param object
	 * @author xuechong
	 */
	public void update(Subject subject,Object object);
}
