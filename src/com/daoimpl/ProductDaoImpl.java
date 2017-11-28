package com.daoimpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.BaseDao;
import com.dao.ProductDao;
import com.pojo.Product;

public class ProductDaoImpl extends BaseDao implements ProductDao{


	public List<Product> getAllProduct() {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from product";
		Object param[]={ };
		ResultSet rs = query(sql,param);
		try {
			while(rs.next()){
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setProductname(rs.getString("productname"));
				product.setQuantity(rs.getInt("quantity"));
				list.add(product);
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return list;
	}

	
	public Product getProductByProductName(Product product) {
		Product product2 = new Product();
		String sql = "select * from product where productname = ?";
		Object param[]={product.getProductname() };
		ResultSet rs = query(sql,param);
		try {
			while(rs.next()){			
				product2.setId(rs.getInt("id"));
				product2.setProductname(rs.getString("productname"));
				product2.setQuantity(rs.getInt("quantity"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return product2;
	}

	public int updateByProduct(Product product) {
		int total = 0;
		String sql= "update product set productname=?,quantity=? where id=?";
		Object param[] = {product.getProductname(),product.getQuantity(),product.getId() };
		total = update(sql,param);
		close();
		return total;
	}


	public Product getProductById(Product product) {
		Product product2 = new Product();
		String sql = "select * from product where id=? ";
		Object param[]={product.getId() };
		System.out.println(product.getId());
		ResultSet rs = query(sql,param);
		try {
			while(rs.next()){
				product2.setId(rs.getInt("id"));
				product2.setProductname(rs.getString("productname"));
				product2.setQuantity(rs.getInt("quantity"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		close();
		return product2;
	}
}
