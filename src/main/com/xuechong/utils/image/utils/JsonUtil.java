package com.xuechong.utils.image.utils;

import java.util.List;


public class JsonUtil {
	
	/**
	 * build the album.json content
	 * @param allFolders
	 * @return
	 */
	public String buildAlbumList(List<String> allFolders){
		StringBuilder result = new StringBuilder(
				allFolders!=null&&!allFolders.isEmpty()?allFolders.size()*25:13);
		result.append("{\"albums\":[");
		if(allFolders!=null&&!allFolders.isEmpty()){
			for (String folder : allFolders) {
				result.append("{\"path\":\"");
				result.append(folder);
				result.append("\",\"desc\":\"\"}");
				result.append(",");
			}
			result.deleteCharAt(result.length()-1);
		}
		result.append("]}");
		return result.toString();
	}
	
	/**
	 * build the contents.json
	 * @param folderPath
	 * @return
	 */
	public String buildContentJson(List<String> allFiles,String folderName){
		StringBuilder result = new StringBuilder("{\"name\":\"");
		result.append(folderName);
		result.append("\",\"pics\":");
		result.append("[");
		if (allFiles!=null&&!allFiles.isEmpty()) {
			for (String string : allFiles) {
				result.append("\"");
				result.append(string.substring(0,
						string.lastIndexOf(".")));//remove '.jpg suf'
				result.append("\",");
			}
			result.deleteCharAt(result.length()-1);
		}
		result.append("]}");
		return result.toString();
	}

	
}
