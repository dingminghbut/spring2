package com.service;

import java.util.List;

import com.pojo.Product;
import com.pojo.TakeOut;

public interface TakeOutService {
	//插入纪录
	public int insertToTakeOut(TakeOut takeout);
	//所有数据
	public List<TakeOut> getAllTakeOut();
	
}
