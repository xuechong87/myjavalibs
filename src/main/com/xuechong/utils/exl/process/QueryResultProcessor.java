package com.xuechong.utils.exl.process;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import com.xuechong.utils.exl.process.builder.ExlBuilder;
import com.xuechong.utils.exl.process.builder.ExlQueryBuilder;
import com.xuechong.utils.exl.process.writer.WorkBookWriter;

public class QueryResultProcessor {
	
	/**
	 * 处理数据并导出EXL
	 * @param head
	 * @param conditions
	 * @param datas
	 * @param queryString
	 * @author xuechong
	 */
	@SuppressWarnings("unchecked")
	public static void Process(String head,List<String> conditions,List<Map> datas,String queryString){
		Workbook book = new HSSFWorkbook();
		if(datas==null||datas.isEmpty()){
			book = ExlBuilder.buildEmptyWorkBook(head, conditions, book, 0);
		}else{
			book = ExlQueryBuilder.buildQueryWorkBook(head,conditions,datas,queryString);
		}
		WorkBookWriter.writeBook(book, head);
	}

	
}
