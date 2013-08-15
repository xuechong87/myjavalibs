package com.xuechong.utils.jsptags.timetag;

import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

@SuppressWarnings("serial")
public class AfterNow extends TagSupport {
	
	private Date date;
	@Override
	public int doStartTag() throws JspException {
		return this.date!=null&&this.date.after(new Date())?EVAL_BODY_INCLUDE:SKIP_BODY;
	}
	
	/////////////////////////
	/////getters&setters////
	/////////////////////////
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
