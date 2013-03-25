package com.xuechong.utils.json;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.formula.functions.T;

import com.google.gson.Gson;
import com.xuechong.utils.http.UrlConnectionUtil;
import com.xuechong.utils.http.mapping.Parameter;

public class JsonUtil {
	
	private static final Gson gson = new Gson();
	
	public static Collection<T> getObjList(Type type,String filePath){
		return gson.fromJson(loadFile(filePath), type);
	}
	public static Collection<T> getObjectList(Type type,String url,Collection<Parameter> parameters){
		String responseStr=null;
		try {
			responseStr = UrlConnectionUtil.postReuqest(url, parameters);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return gson.fromJson(responseStr==null?"":responseStr, type);
	}
	/**
	 * get String from json file
	 * @param filePath
	 * @return
	 * @author xuechong
	 */
	private static String loadFile(String filePath){
		try {
			return FileUtils.readFileToString(
					new File(
							Thread.currentThread().getContextClassLoader().
							getResource(filePath).toURI()));
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return "";
		}
	}
}
