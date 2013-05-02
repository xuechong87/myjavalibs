package com.xuechong.utils.image;

import com.xuechong.utils.image.form.MainForm;

public class Processor implements Runnable{
	
	private MainForm form;
	public Processor(MainForm form){
		this.form = form;
	}
	/**
	 * the main process method 
	 */
	@Override
	public void run() {
		for (int i = 0; i < Integer.MAX_VALUE-100; i++) {
			System.out.println("111");
		}
		form.notifyProcessDone();
	}
	
}
