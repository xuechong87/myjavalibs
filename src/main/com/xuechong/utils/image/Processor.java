package com.xuechong.utils.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.imageio.stream.FileImageInputStream;

import org.apache.commons.io.FileUtils;

import com.xuechong.utils.image.form.MainForm;
import com.xuechong.utils.image.form.StatusLogger;
import com.xuechong.utils.image.utils.FileUtil;
import com.xuechong.utils.image.utils.ImageUtils;
import com.xuechong.utils.image.utils.JsonUtil;

public class Processor implements Runnable{
	
	
	private static final boolean resizeCover = Boolean.TRUE;
	private static final boolean resizeImage = Boolean.TRUE;
	private static final int coverMaxPix = 110;//the max shorter length 
	private static final String ALBUM = "albumlist.json";
	private static final String CONTENT = "contents.json";
	private static final String PHOTO_FOLDER = "photo";
	private static final int contentMaxSize = 750;
	private static final String coverName = "0.jpg";
	
	private final MainForm form;
	private FileUtil fileUtil = new FileUtil();
	private JsonUtil jsonUtil = new JsonUtil();
	private ImageUtils imgUtil = new ImageUtils();
	
	private StatusLogger logger ;
	private String basePath ;
	
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
		execute();
		form.notifyProcessDone();
	}
	
	
	private void execute(){
		try {
			createAlbumListJson();
			doEachFolder();
		} catch (Exception e) {
			e.printStackTrace();
			this.logger.replace("error");
		}
	}
	
	private void doEachFolder() throws IOException {
		for(String path :fileUtil.getFolderList(this.basePath + File.separator + PHOTO_FOLDER)){
			String folderPath =new StringBuilder().
				append(this.basePath).append(File.separator).append(PHOTO_FOLDER).
				append(File.separator).append(path).toString();
			if(resizeCover){
				resizeCover(folderPath);
			}
			if(resizeImage){
				resizeImg(folderPath);
			}
			createSmallImages(folderPath);
			createContentJson(folderPath);
		}
	}
	
	private void createSmallImages(String folderPath) throws IOException {
		List<String> imgList = this.fileUtil.getAllImageNames(folderPath, false);
		for (String imgName : imgList) {
			BufferedImage img = ImageUtils.squareImg(folderPath + File.separator + imgName);
			ImageUtils.writeJPG(this.imgUtil.scalByHeight(img, 80), 
								folderPath + File.separator + "s_"+ imgName);
		}
	}
	
	private void resizeImg(String folderPath) throws IOException {
		List<String> imgList = this.fileUtil.getAllImageNames(folderPath, false);
		for (String imgName : imgList) {
			String imgPath = folderPath + File.separator + imgName;
			BufferedImage img = ImageUtils.readImage(imgPath);
			if(img.getHeight()>contentMaxSize||img.getWidth()>contentMaxSize){
				if(img.getWidth()>img.getHeight()){
					img = this.imgUtil.scalByWidth(img, contentMaxSize);
				}else{
					img = this.imgUtil.scalByHeight(img, contentMaxSize);
				}
				ImageUtils.writeJPG(img,imgPath);
			}
		}
	}
	
	private void createContentJson(String folderPath) throws IOException {
		List<String> imgList = this.fileUtil.getAllImageNames(folderPath, false);
		String folderName = folderPath.substring(
				folderPath.lastIndexOf(File.separator)+1, folderPath.length());
		String json = this.jsonUtil.buildContentJson(imgList,folderName);
		this.fileUtil.writeFile(folderPath + File.separator + CONTENT, json);
	}
	
	private void resizeCover(String folderPath) throws IOException {
		String imgPath = folderPath + File.separator + coverName;
		BufferedImage img = ImageUtils.readImage(imgPath);
		ImageUtils.writeJPG(this.imgUtil.scalByHeight(img, coverMaxPix), imgPath);
	}
	
	private void createAlbumListJson() throws IOException {
		String json = jsonUtil.buildAlbumList(fileUtil.getFolderList(this.basePath + File.separator + PHOTO_FOLDER));
		this.fileUtil.writeFile(this.basePath + File.separator + ALBUM, json);
	}
	
}
