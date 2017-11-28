package com.daoimpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.BaseDao;
import com.dao.TakeOutDao;
import com.pojo.TakeOut;

public class TakeOutDaoImpl extends BaseDao implements TakeOutDao{


	public List<TakeOut> getAllTakeOut() {
		List<TakeOut> list = new ArrayList<TakeOut>();
		String sql = "select * from takeout";
		Object param[]={};
		ResultSet rs= query(sql,param);
		try {
			while(rs.next()){
				TakeOut takeout = new TakeOut();
				takeout.setId(rs.getInt("id"));
				takeout.setQuantity(rs.getInt("quantity"));
				takeout.setOutdate(rs.getTimestamp("outdate"));
				takeout.setHandler(rs.getString("handler"));
				takeout.setProductid(rs.getInt("productid"));
				list.add(takeout);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		close();
		return list;
	}

	public int insertToTakeOut(TakeOut takeout) {
		int total = 0;
		String sql = "insert into takeout(id,quantity,outdate,handler,productid)values(?,?,?,?,?)";
		Object param[] = {takeout.getId(),takeout.getQuantity(),takeout.getOutdate(),takeout.getHandler(),takeout.getProductid()};
		total = update(sql,param);
		close();
		return total;
	}
	
}
