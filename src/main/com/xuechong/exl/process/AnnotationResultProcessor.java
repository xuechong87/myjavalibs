package com.xuechong.exl.process;

import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

import com.xuechong.exl.process.builder.ExlAnnotationBuilder;
import com.xuechong.exl.process.builder.ExlBuilder;
import com.xuechong.exl.process.writer.WorkBookWriter;

public class AnnotationResultProcessor {
	
	@SuppressWarnings("unchecked")
	public static void process(String head,List<String> conditions,List dataList,Integer viewType){
		Workbook book;
		if(dataList==null||dataList.isEmpty()){
			book = ExlBuilder.buildEmptyWorkBook(head,conditions);
		}else{
			book = ExlAnnotationBuilder.buildAnnoWorkBook(head,conditions,dataList,viewType);
		}
		WorkBookWriter.writeBook(book);
	}

	
	
}
