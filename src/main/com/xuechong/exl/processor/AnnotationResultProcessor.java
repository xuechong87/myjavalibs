package com.xuechong.exl.processor;

import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

import com.xuechong.exl.annotations.ExlModel;


public class AnnotationResultProcessor {
	
	@SuppressWarnings("unchecked")
	public static void process(String head,List<String> conditions,List dataList,Integer viewType){
		Workbook book;
		if(dataList.isEmpty()){
			book = ExlBuilder.buildEmptyWorkBook(head,conditions);
		}else{
			book = null;
			Class c = dataList.iterator().next().getClass();
			if(c.getAnnotation(ExlModel.class)==null){
				throw new IllegalArgumentException("不支持的导出类型");
			}
		}
		
		writeBook(book);
	}

	/**
	 * 输出
	 * @param book
	 * @author xuechong
	 */
	private static void writeBook(Workbook book) {
		
	}
	
}
