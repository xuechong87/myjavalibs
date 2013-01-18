package com.xuechong.exl.processor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

import com.xuechong.exl.annotations.ExlModel;


public class AnnotationResultProcessor {
	
	@SuppressWarnings("unchecked")
	public static void process(String head,List<String> conditions,List dataList,Integer viewType){
		Workbook book;
		if(dataList==null||dataList.isEmpty()){
			book = ExlBuilder.buildEmptyWorkBook(head,conditions);
		}else{
			book = ExlBuilder.buildWorkBook(head,conditions,dataList,viewType);
		}
		
		writeBook(book);
	}


	/**
	 * 输出
	 * @param book
	 * @author xuechong
	 */
	private static void writeBook(Workbook book) {
		File file = new File("c:/test1.xls");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			book.write(fos);
			fos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			fos = null;
		}
	}
	
	
}
