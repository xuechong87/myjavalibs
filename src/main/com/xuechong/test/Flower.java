package com.xuechong.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.output.FileWriterWithEncoding;

public class Flower {
	private static final String save = "save(\"${name}\",\"${content}\")\n";
	private String name;
	private StringBuilder content = new StringBuilder("");
	
	@Override
	public String toString() {
		return save.replace("${name}", this.name).replace("${content}", this.content.toString());
	}
	public static void main(String[] args) {
		try {
			exe();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void exe() throws Exception{
		File origin = new File("F:/flower.txt");
		File result = new File("F:/flowerResult.txt");
		BufferedReader reader = new BufferedReader(new FileReader(origin));
		char status = 'e';
		List<Flower> flowerList = new LinkedList<Flower>();
		Flower temp = null;
		while(reader.ready()){
			String readStr = reader.readLine();
			if(readStr==null||readStr.trim().isEmpty()){
				status = 'e';
			}else{
				status = status=='e'?'t':'c';
			}
			
			switch(status){
				case 'e':
					if(temp!=null){flowerList.add(temp);}
					break;
				case 't':
					temp = new Flower();
					temp.name = readStr;
					break;
				case 'c':
					temp.content.append(readStr);
					break;
				default:
					break;
			}
		}
		FileWriterWithEncoding writer = new FileWriterWithEncoding(result,"utf-8");
		for (Flower flower : flowerList) {
			
			writer.write(flower.toString());
		}
		writer.flush();
		writer.close();
	}
	
}
