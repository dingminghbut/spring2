package com.service;

import java.util.List;

import com.pojo.Product;
import com.pojo.TakeOut;

public interface TakeOutService {
	//�����¼
	public int insertToTakeOut(TakeOut takeout);
	//��������
	public List<TakeOut> getAllTakeOut();
	
}
