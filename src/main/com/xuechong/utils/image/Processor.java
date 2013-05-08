package com.xuechong.utils.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.stream.FileImageInputStream;

import org.apache.commons.io.FileUtils;

import com.xuechong.utils.image.form.MainForm;
import com.xuechong.utils.image.form.StatusLogger;
import com.xuechong.utils.image.utils.FileUtil;
import com.xuechong.utils.image.utils.ImageUtils;
import com.xuechong.utils.image.utils.JsonUtil;

public class Processor implements Runnable{
	
	
	private static boolean resizeCover = Boolean.FALSE;
	private static final int coverMaxPix = 110;//the max shorter length 
	private static final String ALBUM = "albumlist.json";
	private static final String PHOTO_FOLDER = "photo";
	
	
	private final MainForm form;
	private FileUtil fileUtil = new FileUtil();
	private String basePath ;
	private StatusLogger logger ;
	private ImageUtils imgUtil = new ImageUtils();
	
	public Processor(MainForm form){
		this.form = form;
		this.basePath = form.getSelectedPath();
		this.logger = form.getLogger();
	}
	/**
	 * the main process method 
	 */
	@Override
	public void run() {
		for (int i = 0; i < Integer.MAX_VALUE-100; i++) {
			System.out.println("111");
		}
		execute();
		form.notifyProcessDone();
	}
	
	
	private void execute(){
		try {
			createAlbumListJson();
			doEachFolder();
		} catch (Exception e) {
			this.logger.replace("error");
		}
	}
	
	private void doEachFolder() throws IOException {
		for(String path :fileUtil.getFolderList(this.basePath + File.separator + PHOTO_FOLDER)){
			String folderPath =new StringBuilder().
				append(this.basePath).append(File.separator).append(path).toString();
			if(resizeCover){
				resizeCover(folderPath);
			}
			resizeImg(folderPath);
			createJson(folderPath);
		}
	}
	
	private void resizeImg(String folderPath) {
		
	}
	
	private void createJson(String folderPath) {
		
	}
	
	private void resizeCover(String folderPath) throws IOException {
		BufferedImage img = ImageUtils.readImage(folderPath);
		ImageUtils.writeJPG(this.imgUtil.scalByHeight(img, coverMaxPix), folderPath);
	}
	
	private void createAlbumListJson() throws IOException {
		JsonUtil jsonUtil = new JsonUtil();
		String json = jsonUtil.buildAlbumList(fileUtil.getFolderList(this.basePath));
		File file = new File(this.basePath + File.separator + ALBUM);
		FileWriter writer = new FileWriter(file);
		try {
			writer.write(json);
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			writer.close();
		}
	}
	
}
