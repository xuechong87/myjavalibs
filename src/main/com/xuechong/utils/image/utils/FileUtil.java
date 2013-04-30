package com.xuechong.utils.image.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileUtil {
	
	/**
	 * get all folder in the giver abs path
	 * @param path
	 * @return
	 */
	public static List<String> getFolderList(String path){
		List<String> result = new ArrayList<String>();
		File[] allFiles = getFile(path);
		if (allFiles!=null &&allFiles.length>0) {
			for (int i = 0; i < allFiles.length; i++) {
				if(allFiles[i].isDirectory()){
					result.add(allFiles[i].getName());
				}
			}
		}
		return result;
	}
	
	/**
	 * get all '*.jpg' file  names in the given folder
	 * @return
	 */
	public static List<String> getAllImageNames(String path){
		List<String> result = new ArrayList<String>();
		File[] allFiles = getFile(path);
		if(allFiles!=null&&allFiles.length>0){
			for (int i = 0; i < allFiles.length; i++) {
				if (allFiles[i].isFile()&&isImage(allFiles[i])) {
					result.add(allFiles[i].getName());
				}
			}
		}
		return result;
	}
	
	private static File[] getFile(String absPath){
		return new File(absPath).listFiles();
	}
	
	private static boolean isImage(File f){
		return f.getName().lastIndexOf(".") == f.getName().lastIndexOf(".jpg");
	}
	
	public static void main(String[] args) {
		String path = "I:/GitHub/wangminghui86.github.com/pages/photo/g1";
		System.out.println(getAllImageNames(path));
	}
	
	
}
