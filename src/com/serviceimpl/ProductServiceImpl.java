package com.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import com.dao.ProductDao;
import com.daoimpl.ProductDaoImpl;
import com.pojo.Product;
import com.service.ProductService;

public class ProductServiceImpl implements ProductService{

	ProductDao productdao = new ProductDaoImpl();
	
	@Override
	public List<Product> getAllProduct() {
		List<Product> list = new ArrayList<Product>();
		return list=productdao.getAllProduct();
	}

	@Override
	public Product getProductByProductName(Product product) {
		Product product2 = new Product();
		return product2=productdao.getProductByProductName(product);
	}

	@Override
	public Product getProductById(Product product) {
		Product product2= new Product();
		return product2=productdao.getProductById(product);
	}

	@Override
	public int updateByProduct(Product product) {
		int total = 0;
		total = productdao.updateByProduct(product);
		return total;
	}
	
	

}
