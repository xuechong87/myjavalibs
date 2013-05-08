package com.xuechong.utils.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import com.xuechong.utils.image.form.MainForm;
import com.xuechong.utils.image.form.StatusLogger;
import com.xuechong.utils.image.utils.FileUtil;
import com.xuechong.utils.image.utils.ImageUtils;

public class Processor implements Runnable{
	
	private final MainForm form;
	private FileUtil fileUtil = new FileUtil();
	private static boolean resizeCover = Boolean.FALSE;
	private static final int coverMaxPix = 110;//the max shorter length 
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
		for(String path :fileUtil.getFolderList(this.basePath)){
			String folderPath =new StringBuilder().
				append(this.basePath).append(File.separator).append(path).toString();
			if(resizeCover){
				resizeCover(folderPath);
			}
			resizeImg(folderPath);
			createJson();
		}
	}
	
	private void resizeImg(String folderPath) {
		
	}
	
	private void createJson() {
		
	}
	
	private void resizeCover(String folderPath) throws IOException {
		BufferedImage img = ImageUtils.readImage(folderPath);
		ImageUtils.writeJPG(this.imgUtil.scalByHeight(img, coverMaxPix), folderPath);
	}
	
	private void createAlbumListJson() {
		
	}
	
}
