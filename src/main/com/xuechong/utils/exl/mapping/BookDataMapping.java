package com.xuechong.utils.exl.mapping;

import java.util.ArrayList;
import java.util.List;

/**
 * the mapping of the data and title content in exl
 * @author xuechong
 *
 */
public class BookDataMapping {
	
	private List<String> titles = new ArrayList<String>();
	private List<List<String>> datas = new ArrayList<List<String>>();;
	
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
