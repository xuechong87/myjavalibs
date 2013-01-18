package com.xuechong.exl.mapping;

import java.util.List;

public class WorkBookMapping {
	private String head;
	private List<String> titles;
	@SuppressWarnings("unchecked")
	private List datas;
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public List<String> getTitles() {
		return titles;
	}
	public void setTitles(List<String> titles) {
		this.titles = titles;
	}
	@SuppressWarnings("unchecked")
	public List getDatas() {
		return datas;
	}
	@SuppressWarnings("unchecked")
	public void setDatas(List datas) {
		this.datas = datas;
	}
	
}
