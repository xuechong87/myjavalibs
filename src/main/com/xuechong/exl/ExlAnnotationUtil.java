package com.xuechong.exl;

import java.util.List;

import com.xuechong.exl.process.AnnotationResultProcessor;

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
}
