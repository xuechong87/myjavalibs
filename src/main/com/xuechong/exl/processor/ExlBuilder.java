package com.xuechong.exl.processor;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.xuechong.exl.annotations.ExlModel;
import com.xuechong.exl.styles.ExlStyles;

public class ExlBuilder {
	private static final String NO_DATA_WARN = "没有符合条件的数据!";
	
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
		int row = book.getSheetAt(0).getLastRowNum() + 1;
		book.getSheetAt(0).addMergedRegion(createMergRegion(NO_DATA_WARN,row));
		Row curRow = book.getSheetAt(0).createRow(row);
		Cell cell = curRow.createCell(0);
		cell.setCellStyle(ExlStyles.getHeadStyle(book));
		cell.setCellValue(NO_DATA_WARN);
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
		int curRow =0;
		String headTrim = StringUtils.trimToNull(head);
		headTrim = headTrim==null?"Workbook":headTrim;
		Sheet sheet = book.createSheet(headTrim);
		
		//put headcontent
		Cell headCell = sheet.createRow(curRow).createCell(0);
		sheet.addMergedRegion(createMergRegion(headTrim, curRow));
		headCell.setCellStyle(ExlStyles.getHeadStyle(book));
		headCell.setCellValue(headTrim);
		
		//put conditions
		if(conditions!=null&&!conditions.isEmpty()){
			for (int i = 0,end = conditions.size();i<end;i++) {
				if(i%2==0){//two conditions in each row
					curRow++;
					sheet.createRow(curRow);
				}
				//merg 3 Columns
				Cell conditionCell = sheet.getRow(curRow).createCell(i%2==0?0:3);
				sheet.addMergedRegion(new CellRangeAddress(curRow,curRow,
						conditionCell.getColumnIndex(),conditionCell.getColumnIndex()+2));
				conditionCell.setCellStyle(ExlStyles.getConditionStyle(book));
				conditionCell.setCellValue(conditions.get(i));
			}
		}
		
		
		return book;
	}
	
	/**
	 * merg cal
	 * @param contentStr
	 * @param row
	 * @return
	 * @author xuechong
	 */
	private static CellRangeAddress createMergRegion(String contentStr,Integer row){
		int width =  contentStr.length()/2+1;
		return new CellRangeAddress(row, row, 0, width>6?width:6);
	}

	/**
	 * build book 
	 * @param head
	 * @param conditions
	 * @param dataList
	 * @param viewType
	 * @return
	 * @author xuechong
	 */
	public static Workbook buildWorkBook(String head, List<String> conditions,
			List dataList, Integer viewType) {
		Workbook book = buildHeanAndConditions(head,conditions);
		book = buildEmptyWorkBook(head, conditions);
		//TODO
		for (Object data : dataList) {
			if(validateModel(data)){
				
			}
		}
		return book;
	}
	
	/**
	 * validate if the model can be translate to exl
	 * @param o
	 * @return
	 * @author xuechong
	 */
	private static boolean validateModel(Object o){
		return o.getClass().getAnnotation(ExlModel.class)!=null;
	}
	
	
}
