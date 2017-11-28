package com.test;

import java.sql.Timestamp;
import java.util.List;

import com.pojo.TakeOut;
import com.service.TakeOutService;
import com.serviceimpl.TakeOutServiceImpl;

public class TestTakeOutServiceImpl {

	public static void main(String[] args) {
		TakeOutService takeoutservice = new TakeOutServiceImpl();
		List<TakeOut> list = takeoutservice.getAllTakeOut();
		System.out.println(list);
		TakeOut takeout = new TakeOut();
		takeout.setHandler("ÀîËÄ");
		Timestamp date = new Timestamp(System.currentTimeMillis());	
		takeout.setOutdate(date);
		takeout.setProductid(2);
		takeout.setQuantity(12);
		int total = takeoutservice.insertToTakeOut(takeout);
		System.out.println(total);
	}

}
