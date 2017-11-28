package com.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configure {
	private static Configure configure;
	private static Properties properties;//Properties �ɱ��������л�����м��ء������б���ÿ���������Ӧֵ����һ���ַ�����
	private Configure(){
		System.out.println("-------���뵥������------");

		try {
			properties = new Properties();
			InputStream in = this.getClass().getClassLoader().getResourceAsStream("db.properties");
			properties.load(in);//���ļ���Ϣ���뵽properties������
			in.close();//�ر������
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
	//��properties�ж�ȡ��Ӧ��ֵ
	public String getProperties(String key){
		return properties.getProperty(key);
	}
}
