package com.xuechong.utils.exl.process;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import com.xuechong.utils.exl.annotations.ExlModel;
import com.xuechong.utils.exl.mapping.SheetContent;
import com.xuechong.utils.exl.process.builder.ExlAnnotationBuilder;
import com.xuechong.utils.exl.process.builder.ExlBuilder;
import com.xuechong.utils.exl.process.writer.WorkBookWriter;

public class AnnotationResultProcessor {
	
	/**
	 * process the datas with Annotataions
	 * @throws IllegalArgumentException if there is no {@link ExlModel} Annotation on the data Objects
	 * @param head
	 * @param conditions
	 * @param dataList
	 * @param viewType
	 * @author xuechong
	 */
	@SuppressWarnings("unchecked")
	public static void process(String head,List<String> conditions,List dataList,Integer viewType){
		SheetContent content = new SheetContent(head, conditions, dataList, viewType);
		process(head, content);
	}
	/**
	 * process the datas with Annotataions
	 * @throws NullPointerException if the sheetContents is null or empty
	 * @throws IllegalArgumentException if there is no {@link ExlModel} Annotation on the data Objects
	 * @param fileName
	 * @param sheetContents
	 * @author xuechong
	 */
	public static void process(String fileName,SheetContent... sheetContents){
		if(sheetContents==null||sheetContents.length<1){
			throw new NullPointerException("no SheetContent to build");
		}
		Workbook book = new HSSFWorkbook();
		for (int i = 0;i<sheetContents.length;i++) {
			SheetContent content = sheetContents[i];
			if(content.getDataList()==null||content.getDataList().isEmpty()){
				ExlBuilder.buildEmptyWorkBook(content.getHead(), content.getConditions(),book, i);
			}else{
				ExlAnnotationBuilder.buildAnnoWorkBook(content, book, i);
			}
		}
		WorkBookWriter.writeBook(book,fileName);
	}
	
	
	
}
