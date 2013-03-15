package com.xuechong.utils.exl;

import java.util.List;

import com.xuechong.utils.exl.mapping.SheetContent;
import com.xuechong.utils.exl.process.AnnotationResultProcessor;

public class ExlAnnotationUtil {
	
	@SuppressWarnings("unchecked")
	public static void export(List dataList){
		AnnotationResultProcessor.process(null, null, dataList, null);
	}
	@SuppressWarnings("unchecked")
	public static void export(List dataList,Integer viewType){
		AnnotationResultProcessor.process(null, null, dataList, viewType);
	}
	
	@SuppressWarnings("unchecked")
	public static void export(String head,List dataList){
		AnnotationResultProcessor.process(head, null, dataList, null);
	}
	
	@SuppressWarnings("unchecked")
	public static void export(String head,List dataList,Integer viewType){
		AnnotationResultProcessor.process(head, null, dataList, viewType);
	}
	
	@SuppressWarnings("unchecked")
	public static void export(String head,List<String> conditions,List dataList){
		AnnotationResultProcessor.process(head, conditions, dataList, null);
	}
	
	@SuppressWarnings("unchecked")
	public static void export(String head,List<String> conditions,List dataList,Integer viewType){
		AnnotationResultProcessor.process(head, conditions, dataList, viewType);
	}
	
	public static void export(String fileName,SheetContent[] sheetContents){
		AnnotationResultProcessor.process(fileName, sheetContents);
	}
}
