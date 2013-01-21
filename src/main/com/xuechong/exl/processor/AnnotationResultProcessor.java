package com.xuechong.exl.processor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

public class AnnotationResultProcessor {
	
	@SuppressWarnings("unchecked")
	public static void process(String head,List<String> conditions,List dataList,Integer viewType){
		Workbook book;
		if(dataList==null||dataList.isEmpty()){
			book = ExlBuilder.buildEmptyWorkBook(head,conditions);
		}else{
			book = ExlAnnotationBuilder.buildAnnoWorkBook(head,conditions,dataList,viewType);
		}
		writeBook(book);
	}

	/**
	 * 输出
	 * @param book
	 * @author xuechong
	 */
	private static void writeBook(Workbook book) {
		OutputStream fos = getOutStream();
		try {
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
	
	private static OutputStream getOutStream(){
		File file = new File(File.listRoots()[0].getPath() + "test.xls");
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return fos;
	}
	
}
