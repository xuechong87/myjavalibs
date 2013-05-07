package com.xuechong.utils.image.utils;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
	
	/**
	 * get all folder in the giver abs path
	 * @param path
	 * @return
	 */
	public List<String> getFolderList(String path){
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
	public List<String> getAllImageNames(String folderPath,final boolean includeSmall){
		List<String> result = new ArrayList<String>();
		File folder = new File(folderPath);
		File[] allFiles = folder.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return (
						pathname.isFile()
						&& (!pathname.getName().endsWith(".json"))
						&& (includeSmall ? true:!pathname.getName().startsWith("s_"))
						&& (!pathname.getName().equalsIgnoreCase("0.jpg"))//ignore the index pic 0.jpg
						);
			}
		});

		if(allFiles!=null&&allFiles.length>0){
			for (int i = 0; i < allFiles.length; i++) {
				result.add(allFiles[i].getName());
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
	
	
}
