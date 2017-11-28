package com.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configure {
	private static Configure configure;
	private static Properties properties;//Properties 可保存在流中或从流中加载。属性列表中每个键及其对应值都是一个字符串。
	private Configure(){
		System.out.println("-------进入单例创建------");

		try {
			properties = new Properties();
			InputStream in = this.getClass().getClassLoader().getResourceAsStream("db.properties");
			properties.load(in);//将文件信息读入到properties对象中
			in.close();//关闭输入点
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static Configure getInstance() {
		if(configure==null){
			configure =new Configure();
		}
		return configure;
	}
	//从properties中读取对应的值
	public String getProperties(String key){
		return properties.getProperty(key);
	}
}
