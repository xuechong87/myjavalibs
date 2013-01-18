package com.xuechong.exl.processor;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import com.xuechong.exl.styles.ExlStyles;

public class ExlBuilder {
	
	
	public static Workbook buildEmptyWorkBook(String head,List<String> conditions){
		Workbook book = buildHeanAndConditions(head,conditions);
		return buildNoDataWarns(book);
	}
	
	
	/**
	 * 添加警告信息
	 * @param book
	 * @return
	 * @author xuechong
	 */
	private static Workbook buildNoDataWarns(Workbook book) {
		int row = book.getSheetAt(0).getLastRowNum();
		Row curRow = book.getSheetAt(0).createRow(row+1);
		Cell cell = curRow.createCell(0);
		cell.setCellStyle(ExlStyles.getHeadStyle(book));
		cell.setCellValue("没有符合条件的数据!");
		return book;
	}

	/**
	 * 创建头部与查询条件信息
	 * @param head
	 * @param conditions
	 * @return
	 * @author xuechong
	 */
	private static Workbook buildHeanAndConditions(String head,List<String> conditions){
		Workbook book = new HSSFWorkbook();
		return book;
	}
	
}
