package com.xuechong.utils.image.form;

public class StatusLogger {
	
	private MainForm form;
	private static final String SUF = "当前状态:";
	
	StatusLogger(MainForm form){
		this.form = form;
	}
	
	public void replace(String str){
		this.form.getStatusLabel().setText(SUF + str);
	}
	
	public void append(String str){
		this.form.getStatusLabel().setText(this.form.getStatusLabel().getText() + str);
	}
	
	/**
	 * clear all
	 */
	public void clear(){
		this.form.getStatusLabel().setText("");
	}
	
	
}
