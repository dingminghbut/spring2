package com.test;

import java.util.List;

import com.dao.ProductDao;
import com.daoimpl.ProductDaoImpl;
import com.pojo.Product;

public class TestProductDaoImpl {


	public static void main(String[] args) {
		//��ѯ����
		ProductDao productdao = new ProductDaoImpl();
		List<Product> list = productdao.getAllProduct();
		System.out.println(list);
		//��������ѯ
		Product product = new Product();
		product.setProductname("����");
		Product product2 = productdao.getProductByProductName(product);
		System.out.println(product2);	
		product.setId(2);
		
		
//		driverschool.setId(2);
//		int total = driverschooldao.updateById(driverschool);
//		System.out.println(total);
//		driverschool.setId(2);
//		Product driverschool2 = driverschooldao.getDriverSchoolById(driverschool);
//		System.out.println(driverschool2);
			
	}

}
