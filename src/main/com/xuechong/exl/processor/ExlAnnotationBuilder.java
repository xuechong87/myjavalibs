package com.xuechong.exl.processor;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;

import com.xuechong.exl.annotations.ExlData;
import com.xuechong.exl.annotations.ExlModel;
import com.xuechong.exl.mapping.BookDataMapping;

public class ExlAnnotationBuilder {
	
	/**
	 * build book 
	 * @param head
	 * @param conditions
	 * @param dataList
	 * @param viewType
	 * @return
	 * @author xuechong
	 */
	@SuppressWarnings("unchecked")
	public static Workbook buildAnnoWorkBook(String head, List<String> conditions,
			List dataList, Integer viewType) {
		Workbook book = ExlBuilder.buildHeanAndConditions(head,conditions);
		book = ExlBuilder.buildEmptyWorkBook(head, conditions);
		//TODO
		BookDataMapping bookData = new BookDataMapping();
		bookData.setTitles(encapeTitles(dataList.get(0),viewType));
		for (Object data : dataList) {
			if(validateModel(data)){
				
			}else{
				throw new IllegalArgumentException("导出EXL时不支持的数据类型",new Throwable("no annotation " + ExlModel.class.getName() + " find on object"));
			}
		}
		return book;
	}
	
	/**
	 * encape the titles
	 * @param data
	 * @param viewType
	 * @return
	 * @author xuechong
	 */
	private static List<String> encapeTitles(Object data,Integer viewType){
		List<String> result = null;
		Field[] fiedls = data.getClass().getFields();
		Map<Integer, String> titleMap = new TreeMap<Integer, String>();
		ExlData dataAnno;
		
		for (Field field : fiedls) {
			dataAnno = field.getAnnotation(ExlData.class);
			if(dataAnno!=null){
				if(StringUtils.isNotBlank(dataAnno.title()[viewType])){
					titleMap.put(dataAnno.sortId(), dataAnno.title()[viewType]);
				}
				
			}
		}
		
		result = new ArrayList<String>(titleMap.values());
		return result;
	}
	/**
	 * validate if the model can be translate to exl<br>
	 * (wether the object has the <b>ExlModel<b> annotataion on its head)
	 * @param o
	 * @return
	 * @author xuechong
	 */
	private static boolean validateModel(Object o){
		return o.getClass().getAnnotation(ExlModel.class)!=null;
	}
	
	
}
