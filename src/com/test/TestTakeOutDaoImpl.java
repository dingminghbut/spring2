package com.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.dao.TakeOutDao;
import com.daoimpl.TakeOutDaoImpl;
import com.pojo.TakeOut;

public class TestTakeOutDaoImpl {


	public static void main(String[] args) {
		//取所有的值
		TakeOutDao takeoutdao = new TakeOutDaoImpl();
		TakeOut takeout = new TakeOut();
		takeout.setHandler("张三");
		takeout.setProductid(2);	
		Timestamp date = new Timestamp(System.currentTimeMillis());	
		takeout.setOutdate(date);		
		takeout.setQuantity(1);		
		takeoutdao.insertToTakeOut(takeout);
		
		List<TakeOut> list =  takeoutdao.getAllTakeOut();
		System.out.println(list);
//		TakeOut cityname = new TakeOut();
//		cityname.setId(1);
//		TakeOut cityname2 = citynamedao.getCityNameById(cityname);
//		System.out.println(cityname2);	
	}

}
