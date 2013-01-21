package com.xuechong.exl.process.writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Workbook;

public class WorkBookWriter {
	/**
	 * 输出
	 * @param book
	 * @author xuechong
	 */
	public static void writeBook(Workbook book) {
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
	
	public static OutputStream getOutStream(){
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
