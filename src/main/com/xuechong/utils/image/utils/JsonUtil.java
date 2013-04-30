package com.xuechong.utils.image.utils;

import java.util.List;


public class JsonUtil {
	
	/**
	 * build the album.json content
	 * @param allFolders
	 * @return
	 */
	public static String buildAlbumList(List<String> allFolders){
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

	
	public static void main(String[] arg){
		String path = "I:/GitHub/wangminghui86.github.com/pages/photo";
		System.out.println(buildAlbumList(FileUtil.getFolderList(path)));
	}
}
