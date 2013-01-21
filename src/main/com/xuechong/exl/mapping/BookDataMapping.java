package com.xuechong.exl.mapping;

import java.util.List;

public class BookDataMapping {
	
	private List<String> titles;
	private List<List<String>> datas;
	
	public List<String> getTitles() {
		return titles;
	}
	public void setTitles(List<String> titles) {
		this.titles = titles;
	}
	public List<List<String>> getDatas() {
		return datas;
	}
	public void setDatas(List<List<String>> datas) {
		this.datas = datas;
	}
	
}
