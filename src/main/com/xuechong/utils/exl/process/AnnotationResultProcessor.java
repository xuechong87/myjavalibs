package com.xuechong.utils.exl.process;

import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

import com.xuechong.utils.exl.process.builder.ExlAnnotationBuilder;
import com.xuechong.utils.exl.process.builder.ExlBuilder;
import com.xuechong.utils.exl.process.writer.WorkBookWriter;

public class AnnotationResultProcessor {
	
	/**
	 * process the datas with Annotataions
	 * @throws IllegalArgumentException if there is no ExlModel Annotation on the data Objects
	 * @param head
	 * @param conditions
	 * @param dataList
	 * @param viewType
	 * @author xuechong
	 */
	@SuppressWarnings("unchecked")
	public static void process(String head,List<String> conditions,List dataList,Integer viewType){
		Workbook book;
		if(dataList==null||dataList.isEmpty()){
			book = ExlBuilder.buildEmptyWorkBook(head,conditions);
		}else{
			book = ExlAnnotationBuilder.buildAnnoWorkBook(head,conditions,dataList,viewType);
		}
		WorkBookWriter.writeBook(book,head);
	}
	
}