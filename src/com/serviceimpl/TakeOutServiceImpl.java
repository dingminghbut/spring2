package com.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import com.dao.TakeOutDao;
import com.daoimpl.TakeOutDaoImpl;
import com.pojo.TakeOut;
import com.service.TakeOutService;

public class TakeOutServiceImpl implements TakeOutService{
	
	TakeOutDao takeoutdao = new TakeOutDaoImpl();
	
	public int insertToTakeOut(TakeOut takeout) {
		int total = 0;
		total = takeoutdao.insertToTakeOut(takeout);
		return total;
	}
	
	public List<TakeOut> getAllTakeOut() {
		List<TakeOut> list = new ArrayList<TakeOut>();	
		return list = takeoutdao.getAllTakeOut();
	}
	
}
