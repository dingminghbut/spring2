package com.dao;

import java.util.List;

import com.pojo.TakeOut;

public interface TakeOutDao {
	public int insertToTakeOut(TakeOut takeout);
	public List<TakeOut> getAllTakeOut();
}
